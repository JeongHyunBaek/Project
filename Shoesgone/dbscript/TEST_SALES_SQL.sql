DROP TABLE ITEMS;
DROP TABLE ORDERS;
DROP SEQUENCE ITEM_SEQ;
DROP SEQUENCE SALES_SEQ;
COMMIT;

CREATE SEQUENCE ITEM_SEQ
INCREMENT BY 1
START WITH 1
NOMINVALUE
NOMAXVALUE
NOCYCLE
NOCACHE;

CREATE SEQUENCE ORDERS_SEQ
INCREMENT BY 1
START WITH 1
NOMINVALUE
NOMAXVALUE
NOCYCLE
NOCACHE;

CREATE SEQUENCE PICTURES_SEQ
INCREMENT BY 1
START WITH 1
NOMINVALUE
NOMAXVALUE
NOCYCLE
NOCACHE;

CREATE TABLE ITEMS
(
ITEM_NO	NUMBER CONSTRAINT ITEM_NO_PK PRIMARY KEY,	
ITEM_ENG_NAME VARCHAR2(100 BYTE) CONSTRAINT ITEM_NAME_NN NOT NULL,
ITEM_KR_NAME	VARCHAR2(100 BYTE),
ITEM_BRAND VARCHAR2(50 BYTE) CONSTRAINT ITEM_BRAND_NN	NOT NULL,
ITEM_MODELNO VARCHAR2(50 BYTE) CONSTRAINT ITEM_MODELNO_NN	NOT NULL,
ITEM_COLORS VARCHAR2(100 BYTE),
ITEM_PRICE	NUMBER CONSTRAINT ITEM_PRICE_NN NOT NULL,
ITEM_REG_DATE	 DATE CONSTRAINT ITEM_REG_DATE_NN	NOT NULL,
ITEM_DROP_DATE DATE,
ITEM_SIZES	VARCHAR2(200 BYTE) CONSTRAINT ITEM_SIZES_NN NOT NULL
);
COMMENT ON COLUMN ITEMS.ITEM_NO IS '물품번호';
COMMENT ON COLUMN ITEMS.ITEM_ENG_NAME IS '물품 영문명';
COMMENT ON COLUMN ITEMS.ITEM_KR_NAME IS '물품 한국명';
COMMENT ON COLUMN ITEMS.ITEM_BRAND IS '물품 브랜드';
COMMENT ON COLUMN ITEMS.ITEM_MODELNO IS '물품 모델번호';
COMMENT ON COLUMN ITEMS.ITEM_COLORS IS '물품 색상';
COMMENT ON COLUMN ITEMS.ITEM_PRICE IS '물품 출고가';
COMMENT ON COLUMN ITEMS.ITEM_REG_DATE IS '물품 등록날짜';
COMMENT ON COLUMN ITEMS.ITEM_DROP_DATE IS '물품 출시일';
COMMENT ON COLUMN ITEMS.ITEM_SIZES IS '물품 제공 사이즈';

CREATE TABLE ORDERS
(
    ORDERS_NO NUMBER CONSTRAINT ORDERS_NO_PK PRIMARY KEY,
    ITEM_MODELNO VARCHAR(30) CONSTRAINT MODELNO_NN NOT NULL,
    SHOES_SIZE NUMBER CONSTRAINT ORDERS_SHOES_SIZE_NN NOT NULL,
    PRICE NUMBER CONSTRAINT ORDERS_PRICE_NN NOT NULL,
    PUR_DATE DATE CONSTRAINT ORDERS_PUR_DATE_NN NOT NULL
);

CREATE TABLE PICTURES
(
    PICTURES_NO NUMBER CONSTRAINT PICTURES_NO_PK PRIMARY KEY,
    PICTURES_PATH VARCHAR2(100 BYTE)
);