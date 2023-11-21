CREATE KEYSPACE IF NOT EXISTS "APP"
    WITH REPLICATION = {'class':'SimpleStrategy', 'replication_factor':3};


CREATE TABLE IF NOT EXISTS "APP".goods (
    id uuid,
    name varchar,
    description varchar,
    internal_id uuid,
    sku int,
    created_at timeuuid,
    updated_at timeuuid,
  PRIMARY KEY ((id))
) WITH comment = 'Table with all goods information.';

INSERT INTO "APP".goods (id, name, description)
    VALUES (5b6962dd-3f90-4c93-8f61-eabfa4a803e2, 'Test Product','Test Product description');

