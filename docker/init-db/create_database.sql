DO
$do$
BEGIN
   IF NOT EXISTS (
      SELECT
      FROM   pg_catalog.pg_database
      WHERE  datname = 'billDB') THEN
      CREATE DATABASE "billDB";
   END IF;
END
$do$;
