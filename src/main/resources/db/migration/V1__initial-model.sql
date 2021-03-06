
CREATE MEMORY TABLE "PUBLIC"."BRAND"(
    "ID" BIGINT NOT NULL,
    "BRAND_NAME" VARCHAR(255)
);           
ALTER TABLE "PUBLIC"."BRAND" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_3" PRIMARY KEY("ID");        
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.BRAND;   
CREATE MEMORY TABLE "PUBLIC"."PRICE"(
    "ID" BIGINT NOT NULL,
    "CURRENCY" VARCHAR(255),
    "END_DATE" TIMESTAMP,
    "PRICE_PRODUCT" FLOAT,
    "PRIORITY" INTEGER,
    "START_DATE" TIMESTAMP,
    "BRAND_ID" BIGINT,
    "PRODUCT_ID" BIGINT
);      
ALTER TABLE "PUBLIC"."PRICE" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_4" PRIMARY KEY("ID");        
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.PRICE;   
CREATE MEMORY TABLE "PUBLIC"."PRODUCT"(
    "ID" BIGINT NOT NULL,
    "PRODUCT_NAME" VARCHAR(255)
);       
ALTER TABLE "PUBLIC"."PRODUCT" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1" PRIMARY KEY("ID");      
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.PRODUCT; 
ALTER TABLE "PUBLIC"."PRICE" ADD CONSTRAINT "PUBLIC"."FKK4MBGQF5YRU5IB5B6W5L6UKKJ" FOREIGN KEY("PRODUCT_ID") REFERENCES "PUBLIC"."PRODUCT"("ID") NOCHECK;     
ALTER TABLE "PUBLIC"."PRICE" ADD CONSTRAINT "PUBLIC"."FKIM0RL4MLODCWFY6D5D0VQ5ENR" FOREIGN KEY("BRAND_ID") REFERENCES "PUBLIC"."BRAND"("ID") NOCHECK;         
