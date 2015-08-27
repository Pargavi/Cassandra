CREATE KEYSPACE dev WITH replication = {
  'class': 'SimpleStrategy',
  'replication_factor': '1'
};

USE dev;

CREATE TABLE dev.users (
    user_id text PRIMARY KEY,
    age int,
    first text,
    last text
) ;