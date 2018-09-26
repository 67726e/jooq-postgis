--// add example table
-- Migration SQL that makes the change goes here.

CREATE TABLE example(
	id SERIAL NOT NULL,
	line_column GEOMETRY(LINESTRING) NOT NULL,
	point_column GEOMETRY(POINT) NOT NULL,
	polygon_column GEOMETRY(POLYGON) NOT NULL,
	multiline_column GEOMETRY(MULTILINESTRING) NOT NULL,
	multipoint_column GEOMETRY(MULTIPOINT) NOT NULL,
	multipolygon_column GEOMETRY(MULTIPOLYGON) NOT NULL,
	PRIMARY KEY(id)
);

--//@UNDO
-- SQL to undo the change goes here.

DROP TABLE example;

