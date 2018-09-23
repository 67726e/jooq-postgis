--// enable postgis
-- Migration SQL that makes the change goes here.

CREATE EXTENSION postgis;

--//@UNDO
-- SQL to undo the change goes here.

DROP EXTENSION postgis;

