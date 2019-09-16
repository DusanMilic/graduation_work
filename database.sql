CREATE TYPE "user_type" AS ENUM (
  'VET',
  'PET_OWNER'
);

CREATE TYPE "appointment_status" AS ENUM (
  'PENDING',
  'APPROVED',
  'DECLIENED'
);

CREATE TYPE "species" AS ENUM (
  'DOG',
  'CAT'
);

CREATE TABLE "users" (
  "id" int PRIMARY KEY,
  "full_name" varchar,
  "user_type" user_type,
  "email" varchar,
  "password" varchar
);

CREATE TABLE "appointments" (
  "id" int PRIMARY KEY,
  "vet_id" int,
  "pet_owner_id" int,
  "pet_id" int,
  "status" appointment_status,
  "time" timestamp
);

CREATE TABLE "pets" (
  "id" int PRIMARY KEY,
  "owner" int,
  "name" varchar,
  "feeding_habits" varchar,
  "alergies" varchar,
  "species" species,
  "breed" varchar,
  "age" int,
  "weight" int
);

CREATE TABLE "photos" (
  "id" int PRIMARY KEY,
  "pet_id" int,
  "photo" bytea
);

CREATE TABLE "medical_files" (
  "id" int PRIMARY KEY,
  "pet_id" int,
  "createor" int,
  "stats" varchar,
  "vaccination" varchar,
  "medicine" varchar,
  "lab_results" varchar,
  "report" varchar
);

ALTER TABLE "medical_files" ADD FOREIGN KEY ("createor") REFERENCES "users" ("id");

ALTER TABLE "medical_files" ADD FOREIGN KEY ("pet_id") REFERENCES "pets" ("id");

ALTER TABLE "photos" ADD FOREIGN KEY ("pet_id") REFERENCES "pets" ("id");

ALTER TABLE "pets" ADD FOREIGN KEY ("owner") REFERENCES "users" ("id");

ALTER TABLE "appointments" ADD FOREIGN KEY ("vet_id") REFERENCES "users" ("id");

ALTER TABLE "appointments" ADD FOREIGN KEY ("pet_owner_id") REFERENCES "users" ("id");
