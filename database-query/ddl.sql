CREATE TABLE USERS (
    USER_ID NUMBER PRIMARY KEY ,
    USERNAME VARCHAR2(512)
);

CREATE TABLE TRAINING_DETAILS (
    USER_TRAINING_ID NUMBER PRIMARY KEY ,
    USER_ID NUMBER REFERENCES USERS (USER_ID),
    TRAINING_ID NUMBER,
    TRAINING_DATE DATE
);