CREATE KEYSPACE IF NOT EXISTS "APP"
    WITH REPLICATION = {'class':'SimpleStrategy', 'replication_factor':3};

USE "APP";

CREATE TABLE IF NOT EXISTS goods (
    id uuid,
    name varchar,
    description varchar,
    sku varchar,
    created_at timeuuid,
    updated_at timeuuid,
  PRIMARY KEY ((id))
) WITH comment = 'Table with all goods information.';

INSERT INTO goods (id, name, description, sku)
    VALUES (5b6962dd-3f90-4c93-8f61-eabfa4a803e1, 'Test Product','Test Product description', 'BK14300SV');

INSERT INTO goods (id, name, description, sku)
    VALUES (5b6962dd-3f90-4c93-8f61-eabfa4a803e2, 'Test Product 2','Test Product description 2', 'BK14301SV');