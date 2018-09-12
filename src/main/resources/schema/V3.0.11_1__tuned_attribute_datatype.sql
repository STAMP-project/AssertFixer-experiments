ALTER TABLE "public"."attributes" ADD COLUMN "datatype" text;

UPDATE "public"."attributes"
SET "datatype"='boolean'
WHERE "id" IN (SELECT id FROM "public"."attributes" WHERE "boolean_value" IS NOT NULL);

UPDATE "public"."attributes"
SET "datatype"='date'
WHERE "id" IN (SELECT id FROM "public"."attributes" WHERE "datetime_value" IS NOT NULL);

UPDATE "public"."attributes"
SET "datatype"='double'
WHERE "id" IN (SELECT id FROM "public"."attributes" WHERE "double_value" IS NOT NULL);

UPDATE "public"."attributes"
SET "datatype"='string'
WHERE "id" IN (SELECT id FROM "public"."attributes" WHERE "string_value" IS NOT NULL);

ALTER TABLE "public"."attributes" ALTER COLUMN "datatype" SET NOT NULL;