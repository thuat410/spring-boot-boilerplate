-- =====================================================================
-- Base tables
-- =====================================================================

CREATE TABLE IF NOT EXISTS `user`
(
    id         BIGINT       NOT NULL,
    username   VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL, -- UserStatusEnum, stored as STRING
    created_at TIMESTAMP    NULL,
    updated_at TIMESTAMP    NULL,
    version    BIGINT       NOT NULL DEFAULT 0,
    PRIMARY KEY (id),
    CONSTRAINT chk_user_status
        CHECK (status IN ('ENABLED', 'DISABLED', 'NOT_VERIFIED'))
);

CREATE TABLE IF NOT EXISTS category
(
    id         BIGINT       NOT NULL,
    name       VARCHAR(255) NOT NULL,
    created_at TIMESTAMP    NULL,
    updated_at TIMESTAMP    NULL,
    version    BIGINT       NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS product
(
    id          BIGINT       NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description TEXT         NULL,
    category_id BIGINT       NOT NULL,
    created_at  TIMESTAMP    NULL,
    updated_at  TIMESTAMP    NULL,
    version     BIGINT       NOT NULL DEFAULT 0,
    PRIMARY KEY (id),
    CONSTRAINT fk_product_category
        FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE IF NOT EXISTS tag
(
    id         BIGINT       NOT NULL,
    name       VARCHAR(255) NOT NULL,
    created_at TIMESTAMP    NULL,
    updated_at TIMESTAMP    NULL,
    version    BIGINT       NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `order`
(
    id         BIGINT      NOT NULL,
    user_id    BIGINT      NOT NULL,
    status     VARCHAR(50) NOT NULL, -- OrderStatusEnum, stored as STRING
    created_at TIMESTAMP   NULL,
    updated_at TIMESTAMP   NULL,
    version    BIGINT      NOT NULL DEFAULT 0,
    PRIMARY KEY (id),
    CONSTRAINT fk_order_user
        FOREIGN KEY (user_id) REFERENCES `user` (id),
    CONSTRAINT chk_order_status
        CHECK (status IN ('CREATED', 'PAID', 'SHIPPED', 'COMPLETED', 'CANCELLED'))
);

CREATE TABLE IF NOT EXISTS order_item
(
    id         BIGINT         NOT NULL,
    order_id   BIGINT         NOT NULL,
    product_id BIGINT         NOT NULL,
    quantity   INT            NULL,
    unit_price DECIMAL(19, 4) NULL,
    currency   VARCHAR(10)    NULL,
    created_at TIMESTAMP      NULL,
    updated_at TIMESTAMP      NULL,
    version    BIGINT         NOT NULL DEFAULT 0,
    PRIMARY KEY (id),
    CONSTRAINT fk_order_item_order
        FOREIGN KEY (order_id) REFERENCES `order` (id),
    CONSTRAINT fk_order_item_product
        FOREIGN KEY (product_id) REFERENCES product (id)
);

CREATE TABLE IF NOT EXISTS product_price
(
    id         BIGINT         NOT NULL,
    product_id BIGINT         NOT NULL,
    currency   VARCHAR(10)    NOT NULL,
    amount     DECIMAL(19, 4) NOT NULL,
    created_at TIMESTAMP      NULL,
    updated_at TIMESTAMP      NULL,
    version    BIGINT         NOT NULL DEFAULT 0,
    PRIMARY KEY (id),
    CONSTRAINT fk_product_price_product
        FOREIGN KEY (product_id) REFERENCES product (id)
);

CREATE UNIQUE INDEX ux_product_price_product_currency
    ON product_price (product_id, currency);

-- =====================================================================
-- Many-to-many join table: product <-> tag
-- =====================================================================

CREATE TABLE IF NOT EXISTS product_tag
(
    product_id BIGINT NOT NULL,
    tag_id     BIGINT NOT NULL,
    PRIMARY KEY (product_id, tag_id),
    CONSTRAINT fk_product_tag_product
        FOREIGN KEY (product_id) REFERENCES product (id),
    CONSTRAINT fk_product_tag_tag
        FOREIGN KEY (tag_id) REFERENCES tag (id)
);