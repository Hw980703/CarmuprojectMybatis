--------------------------------------------------------
--  파일이 생성됨 - 화요일-8월-08-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CARMU
--------------------------------------------------------

  CREATE TABLE "CARMU"."CARMU" 
   (	"MEMBER_ID" VARCHAR2(50 BYTE), 
	"MEMBER_PW" VARCHAR2(50 BYTE), 
	"MEMBER_NAME" VARCHAR2(50 BYTE), 
	"MEMBER_NICNAME" VARCHAR2(18 BYTE), 
	"MEMBER_EMAIL" VARCHAR2(50 BYTE), 
	"MEMBER_PHONE" VARCHAR2(50 BYTE), 
	"MEMBER_DATE" DATE DEFAULT SYSDATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table KORFREEBOARD
--------------------------------------------------------

  CREATE TABLE "CARMU"."KORFREEBOARD" 
   (	"NOTICE_NO" NUMBER, 
	"NOTICE_SUBJECT" VARCHAR2(50 BYTE), 
	"NOTICE_CONTENT" VARCHAR2(2000 BYTE), 
	"NOTICE_WRITER" VARCHAR2(18 BYTE), 
	"NOTICE_DATE" DATE DEFAULT SYSDATE, 
	"NOTICE_GOOD" NUMBER DEFAULT 0, 
	"NOTICE_VIEW" NUMBER DEFAULT 0, 
	"NOTICE_COMMENT" NUMBER DEFAULT 0
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table NOTICE_TBL
--------------------------------------------------------

  CREATE TABLE "CARMU"."NOTICE_TBL" 
   (	"NOTICE_NO" NUMBER, 
	"NOTICE_SUBJECT" VARCHAR2(50 BYTE), 
	"NOTICE_CONTENT" VARCHAR2(1000 BYTE), 
	"NOTICE_WRITER" VARCHAR2(50 BYTE), 
	"NOTICE_DATE" TIMESTAMP (6) DEFAULT SYSTIMESTAMP, 
	"UPDATE_DATE" TIMESTAMP (6) DEFAULT SYSTIMESTAMP, 
	"VIEW_COUNT" NUMBER DEFAULT 0
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into CARMU.CARMU
SET DEFINE OFF;
Insert into CARMU.CARMU (MEMBER_ID,MEMBER_PW,MEMBER_NAME,MEMBER_NICNAME,MEMBER_EMAIL,MEMBER_PHONE,MEMBER_DATE) values ('zkdhk1','85090909','김현우','운영자','zkdhk1@naver.com','01075738416',to_date('23/08/02','RR/MM/DD'));
Insert into CARMU.CARMU (MEMBER_ID,MEMBER_PW,MEMBER_NAME,MEMBER_NICNAME,MEMBER_EMAIL,MEMBER_PHONE,MEMBER_DATE) values ('zkdhk12','85090909','김현우','댕댕','test@naver.com','01075738416',to_date('23/08/07','RR/MM/DD'));
Insert into CARMU.CARMU (MEMBER_ID,MEMBER_PW,MEMBER_NAME,MEMBER_NICNAME,MEMBER_EMAIL,MEMBER_PHONE,MEMBER_DATE) values ('godsuhwan','85090909','대황수환','팩폭수환','suhwan@naver.com','01011111111',to_date('23/08/07','RR/MM/DD'));
REM INSERTING into CARMU.KORFREEBOARD
SET DEFINE OFF;
Insert into CARMU.KORFREEBOARD (NOTICE_NO,NOTICE_SUBJECT,NOTICE_CONTENT,NOTICE_WRITER,NOTICE_DATE,NOTICE_GOOD,NOTICE_VIEW,NOTICE_COMMENT) values (21,'??????',' ?????????','admin',to_date('23/08/04','RR/MM/DD'),0,0,0);
Insert into CARMU.KORFREEBOARD (NOTICE_NO,NOTICE_SUBJECT,NOTICE_CONTENT,NOTICE_WRITER,NOTICE_DATE,NOTICE_GOOD,NOTICE_VIEW,NOTICE_COMMENT) values (22,'ㅎㅇ',' ㅎㅇㅋㅋㅋㅋ','admin',to_date('23/08/04','RR/MM/DD'),0,0,0);
Insert into CARMU.KORFREEBOARD (NOTICE_NO,NOTICE_SUBJECT,NOTICE_CONTENT,NOTICE_WRITER,NOTICE_DATE,NOTICE_GOOD,NOTICE_VIEW,NOTICE_COMMENT) values (23,'ㅎㅇ테스트임',' ㅎㅇㅎㅇ테스트','admin',to_date('23/08/07','RR/MM/DD'),0,0,0);
Insert into CARMU.KORFREEBOARD (NOTICE_NO,NOTICE_SUBJECT,NOTICE_CONTENT,NOTICE_WRITER,NOTICE_DATE,NOTICE_GOOD,NOTICE_VIEW,NOTICE_COMMENT) values (24,'ㅋㅋㅋ','안녕하세요 ','admin',to_date('23/08/07','RR/MM/DD'),0,0,0);
REM INSERTING into CARMU.NOTICE_TBL
SET DEFINE OFF;
Insert into CARMU.NOTICE_TBL (NOTICE_NO,NOTICE_SUBJECT,NOTICE_CONTENT,NOTICE_WRITER,NOTICE_DATE,UPDATE_DATE,VIEW_COUNT) values (1,'공지사항 ㅋㅋ',' ㅋㅋㅋㅋㅎㅇ','admin',to_timestamp('23/08/03 17:17:22.914000000','RR/MM/DD HH24:MI:SSXFF'),to_timestamp('23/08/03 17:17:22.914000000','RR/MM/DD HH24:MI:SSXFF'),0);
Insert into CARMU.NOTICE_TBL (NOTICE_NO,NOTICE_SUBJECT,NOTICE_CONTENT,NOTICE_WRITER,NOTICE_DATE,UPDATE_DATE,VIEW_COUNT) values (2,'공지사항 ㅋㅋ',' ㅋㅋㅋㅋㅎㅇ','admin',to_timestamp('23/08/03 17:17:27.797000000','RR/MM/DD HH24:MI:SSXFF'),to_timestamp('23/08/03 17:17:27.797000000','RR/MM/DD HH24:MI:SSXFF'),0);
Insert into CARMU.NOTICE_TBL (NOTICE_NO,NOTICE_SUBJECT,NOTICE_CONTENT,NOTICE_WRITER,NOTICE_DATE,UPDATE_DATE,VIEW_COUNT) values (3,'ㅎㅇ',' ㅎㅇㅋ','admin',to_timestamp('23/08/03 17:18:22.266000000','RR/MM/DD HH24:MI:SSXFF'),to_timestamp('23/08/03 17:18:22.266000000','RR/MM/DD HH24:MI:SSXFF'),0);
Insert into CARMU.NOTICE_TBL (NOTICE_NO,NOTICE_SUBJECT,NOTICE_CONTENT,NOTICE_WRITER,NOTICE_DATE,UPDATE_DATE,VIEW_COUNT) values (4,'gd',' zzz','admin',to_timestamp('23/08/03 17:18:45.376000000','RR/MM/DD HH24:MI:SSXFF'),to_timestamp('23/08/03 17:18:45.376000000','RR/MM/DD HH24:MI:SSXFF'),0);
Insert into CARMU.NOTICE_TBL (NOTICE_NO,NOTICE_SUBJECT,NOTICE_CONTENT,NOTICE_WRITER,NOTICE_DATE,UPDATE_DATE,VIEW_COUNT) values (5,'gd',' zz','admin',to_timestamp('23/08/03 17:19:17.777000000','RR/MM/DD HH24:MI:SSXFF'),to_timestamp('23/08/03 17:19:17.777000000','RR/MM/DD HH24:MI:SSXFF'),0);
Insert into CARMU.NOTICE_TBL (NOTICE_NO,NOTICE_SUBJECT,NOTICE_CONTENT,NOTICE_WRITER,NOTICE_DATE,UPDATE_DATE,VIEW_COUNT) values (7,'ㅎㅇ',' ㅎㅇㅋㅋ','admin',to_timestamp('23/08/03 17:42:54.192000000','RR/MM/DD HH24:MI:SSXFF'),to_timestamp('23/08/03 17:42:54.192000000','RR/MM/DD HH24:MI:SSXFF'),0);
Insert into CARMU.NOTICE_TBL (NOTICE_NO,NOTICE_SUBJECT,NOTICE_CONTENT,NOTICE_WRITER,NOTICE_DATE,UPDATE_DATE,VIEW_COUNT) values (8,'ㅎㅇ',' ㅎㅇㅋㅋ ㅎㅇㅋㅋ','admin',to_timestamp('23/08/03 17:43:05.853000000','RR/MM/DD HH24:MI:SSXFF'),to_timestamp('23/08/03 17:43:05.853000000','RR/MM/DD HH24:MI:SSXFF'),0);
Insert into CARMU.NOTICE_TBL (NOTICE_NO,NOTICE_SUBJECT,NOTICE_CONTENT,NOTICE_WRITER,NOTICE_DATE,UPDATE_DATE,VIEW_COUNT) values (9,'공지사항임','집가고싶은 사람 손 
저요','admin',to_timestamp('23/08/04 11:03:14.679000000','RR/MM/DD HH24:MI:SSXFF'),to_timestamp('23/08/04 11:03:14.679000000','RR/MM/DD HH24:MI:SSXFF'),0);
--------------------------------------------------------
--  DDL for Index SYS_C007243
--------------------------------------------------------

  CREATE UNIQUE INDEX "CARMU"."SYS_C007243" ON "CARMU"."KORFREEBOARD" ("NOTICE_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007239
--------------------------------------------------------

  CREATE UNIQUE INDEX "CARMU"."SYS_C007239" ON "CARMU"."NOTICE_TBL" ("NOTICE_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table KORFREEBOARD
--------------------------------------------------------

  ALTER TABLE "CARMU"."KORFREEBOARD" ADD PRIMARY KEY ("NOTICE_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "CARMU"."KORFREEBOARD" MODIFY ("NOTICE_SUBJECT" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table NOTICE_TBL
--------------------------------------------------------

  ALTER TABLE "CARMU"."NOTICE_TBL" ADD PRIMARY KEY ("NOTICE_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "CARMU"."NOTICE_TBL" MODIFY ("NOTICE_WRITER" NOT NULL ENABLE);
  ALTER TABLE "CARMU"."NOTICE_TBL" MODIFY ("NOTICE_CONTENT" NOT NULL ENABLE);
  ALTER TABLE "CARMU"."NOTICE_TBL" MODIFY ("NOTICE_SUBJECT" NOT NULL ENABLE);
