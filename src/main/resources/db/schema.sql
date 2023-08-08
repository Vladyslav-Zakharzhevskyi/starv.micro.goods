CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

DROP TABLE IF EXISTS goods;
CREATE TABLE goods
(
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    sku         VARCHAR(12)  NOT NULL,
    internal_id uuid                  DEFAULT gen_random_uuid() NOT NULL,
    created_at  TIMESTAMP(0) NOT NULL DEFAULT now(),
    updated_at  TIMESTAMP(0) NOT NULL DEFAULT now()
);

















