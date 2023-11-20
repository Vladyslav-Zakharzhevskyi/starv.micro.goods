CREATE KEYSPACE IF NOT EXISTS app
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor':3};


CREATE TABLE IF NOT EXISTS app.goods (
    id uuid,
    name varchar,
    description varchar,
    internal_id uuid,
    created_at timeuuid,
    updated_at timeuuid,
  PRIMARY KEY ((id))
) WITH comment = 'Table with all goods information.';

