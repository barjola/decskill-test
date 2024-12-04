CREATE TABLE prices
(
    id         UUID PRIMARY KEY NOT NULL,
    brand_id   BIGINT           NOT NULL,
    start_date TIMESTAMP,
    end_date   TIMESTAMP,
    price_list BIGINT           NOT NULL,
    product_id BIGINT           NOT NULL,
    priority   INT              NOT NULL,
    price      DECIMAL(10, 2)   NOT NULL,
    curr       VARCHAR(3)       NOT NULL
);
