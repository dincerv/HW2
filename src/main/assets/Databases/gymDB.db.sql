BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "gym" (
	"id"	INTEGER,
	"name"	TEXT,
	"equipment"	TEXT,
	"image"	BLOB,
	PRIMARY KEY("id" AUTOINCREMENT)
);
INSERT INTO "gym" VALUES (1,'Bench Press','Bench-Barbell',NULL);
INSERT INTO "gym" VALUES (2,'Biceps','Dumbell',NULL);
INSERT INTO "gym" VALUES (3,'Triceps','Dumbell',NULL);
INSERT INTO "gym" VALUES (4,'Shoulder','Dumbell',NULL);
INSERT INTO "gym" VALUES (5,'Back','Dumbell',NULL);
INSERT INTO "gym" VALUES (6,'Leg','Barbell',NULL);
COMMIT;
