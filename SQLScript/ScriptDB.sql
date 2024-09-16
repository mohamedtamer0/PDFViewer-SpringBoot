/* Formatted on 9/16/2024 11:06:24 PM (QP5 v5.326) */
CREATE TABLE pdf_files
(
    id           NUMBER,
    data         BLOB,
    file_name    VARCHAR2 (255),
    file_type    VARCHAR2 (50),
    PRIMARY KEY (id)
);


CREATE SEQUENCE pdf_files_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;


CREATE OR REPLACE TRIGGER pdf_files_bi
    BEFORE INSERT
    ON pdf_files
    FOR EACH ROW
BEGIN
    IF :new.id IS NULL
    THEN
        SELECT pdf_files_seq.NEXTVAL INTO :new.id FROM DUAL;
    END IF;
END;


SELECT * FROM pdf_files;