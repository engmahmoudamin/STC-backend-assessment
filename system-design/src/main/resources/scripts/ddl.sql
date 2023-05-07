-- PERMISSION_GROUPS --
CREATE TABLE PERMISSION_GROUPS
(
    ID         SERIAL       NOT NULL,
    GROUP_NAME VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);
------------------------------------------------------------------------------
-- PERMISSIONS --
CREATE TABLE PERMISSIONS
(
    ID               SERIAL       NOT NULL,
    USER_EMAIL       VARCHAR(255) NOT NULL,
    PERMISSION_LEVEL VARCHAR(50)  NOT NULL,
    GROUP_ID         INT REFERENCES PERMISSION_GROUPS (ID),
    PRIMARY KEY (ID)
);
------------------------------------------------------------------------------
-- ITEMS --
CREATE TABLE ITEMS
(
    ID                  SERIAL       NOT NULL,
    TYPE                VARCHAR(50)  NOT NULL,
    NAME                VARCHAR(255) NOT NULL,
    PARENT_ID           INT,
    PERMISSION_GROUP_ID INT REFERENCES PERMISSION_GROUPS (ID),
    PRIMARY KEY (ID)
);
ALTER TABLE ITEMS ADD FOREIGN KEY (PARENT_ID) REFERENCES ITEMS(ID);
------------------------------------------------------------------------------
-- FILES --
CREATE TABLE FILES
(
    ID          SERIAL NOT NULL,
    FILE_BINARY bytea  NOT NULL,
    ITEM_ID     INT REFERENCES ITEMS (ID),
    PRIMARY KEY (ID)
);