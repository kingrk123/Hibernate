CREATE TABLE "SYSTEM"."EMPLOYEE" 
   (	"EID" NUMBER(10,0) NOT NULL ENABLE, 
	"ENAME" VARCHAR2(20 BYTE), 
	"EADD" VARCHAR2(20 BYTE), 
	"ESALARY" FLOAT(126), 
	 CONSTRAINT "EMPLOYEE_PK" PRIMARY KEY ("EID"))