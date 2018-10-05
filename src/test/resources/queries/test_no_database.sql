-- Check if no databases are created
SELECT COUNT(datname) FROM pg_database WHERE datname != 'template0' AND datname != 'template1';