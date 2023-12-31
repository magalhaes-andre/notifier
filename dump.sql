-- H2 2.1.214; 
SET DB_CLOSE_DELAY -1;         
;              
CREATE USER IF NOT EXISTS "SA" SALT '6bfe919a871afa27' HASH '1b7f900406a5f4c21ad9e3a54ff1c29856175df7a535b84eb1f0ce97278baced' ADMIN;          
CREATE SEQUENCE "PUBLIC"."MESSAGES_SEQ" START WITH 1 INCREMENT BY 50;          
CREATE MEMORY TABLE "PUBLIC"."MESSAGES"(
    "ID" BIGINT NOT NULL,
    "TIMESTAMP" TIMESTAMP(6),
    "CATEGORY" CHARACTER VARYING(255),
    "MESSAGE" CHARACTER VARYING(255)
);
ALTER TABLE "PUBLIC"."MESSAGES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_13" PRIMARY KEY("ID");     
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.MESSAGES; 
CREATE MEMORY TABLE "PUBLIC"."USERS_LIST"(
    "ID" BIGINT NOT NULL,
    "USERS" JSON
);       
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.USERS_LIST;               
ALTER TABLE "PUBLIC"."MESSAGES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1" CHECK("CATEGORY" IN('SPORTS', 'FINANCE', 'FILMS')) NOCHECK;             
ALTER TABLE "PUBLIC"."USERS_LIST" ADD CONSTRAINT "PUBLIC"."FKG0YGP7N1D21ETQWEOOJ8FLBE9" FOREIGN KEY("ID") REFERENCES "PUBLIC"."MESSAGES"("ID") NOCHECK;        
