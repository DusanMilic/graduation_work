
CREATE TABLE "users" (
  "id" SERIAL PRIMARY KEY,
  "full_name" varchar,
  "user_type" varchar,
  "email" varchar,
  "password" varchar,
  "phone_number" varchar,
  "first_login" int
);

CREATE TABLE "appointments" (
  "id" SERIAL PRIMARY KEY,
  "vet_id" int,
  "pet_owner_id" int,
  "pet_id" int,
  "status" varchar,
  "time" timestamp
);

CREATE TABLE "pets" (
  "id" SERIAL PRIMARY KEY,
  "owner" int,
  "name" varchar,
  "feeding_habits" varchar,
  "alergies" varchar,
  "species" varchar,
  "breed" varchar,
  "age" int,
  "weight" int
);

CREATE TABLE "photos" (
  "id" SERIAL PRIMARY KEY,
  "pet_id" int,
  "photo" bytea
);

CREATE TABLE "medical_files" (
  "id" SERIAL PRIMARY KEY,
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

