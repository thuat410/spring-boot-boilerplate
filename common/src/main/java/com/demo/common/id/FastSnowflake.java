package com.demo.common.id;

public class FastSnowflake {
    private final long workerId;
    private final long datacenterId;

    private static final long WORKER_ID_BITS = 5L;
    private static final long DATACENTER_ID_BITS = 5L;
    private static final long SEQUENCE_BITS = 12L;

    private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);
    private static final long MAX_DATACENTER_ID = ~(-1L << DATACENTER_ID_BITS);

    private static final long WORKER_ID_SHIFT = SEQUENCE_BITS;
    private static final long DATACENTER_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;
    private static final long TIMESTAMP_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATACENTER_ID_BITS;

    private static final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS);

    private static final long TWEPOCH = 1288834974657L;

    private final java.util.concurrent.atomic.AtomicLong lastTimestampSeq = new java.util.concurrent.atomic.AtomicLong(-1L);

    public FastSnowflake(long workerId, long datacenterId) {
        if (workerId > MAX_WORKER_ID || workerId < 0)
            throw new IllegalArgumentException("Invalid workerId");
        if (datacenterId > MAX_DATACENTER_ID || datacenterId < 0)
            throw new IllegalArgumentException("Invalid datacenterId");

        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public long nextId() {
        while (true) {
            long old = lastTimestampSeq.get();
            long lastTimestamp = old >>> 12;
            long sequence = old & SEQUENCE_MASK;

            long now = System.currentTimeMillis();

            if (now < lastTimestamp)
                now = lastTimestamp;

            long newSeq;
            if (now == lastTimestamp) {
                newSeq = (sequence + 1) & SEQUENCE_MASK;
                if (newSeq == 0)
                    now = waitNextMillis(lastTimestamp);
            } else {
                newSeq = 0;
            }

            long next = (now << 12) | newSeq;

            if (lastTimestampSeq.compareAndSet(old, next)) {
                return ((now - TWEPOCH) << TIMESTAMP_SHIFT)
                        | (datacenterId << DATACENTER_ID_SHIFT)
                        | (workerId << WORKER_ID_SHIFT)
                        | newSeq;
            }
        }
    }

    private long waitNextMillis(long lastTimestamp) {
        long now = System.currentTimeMillis();
        while (now <= lastTimestamp) {
            now = System.currentTimeMillis();
        }
        return now;
    }
}
