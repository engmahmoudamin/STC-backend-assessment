-- INSERT INTO USERS --
INSERT INTO USERS VALUES (1, 'John Doe');
INSERT INTO USERS VALUES (2, 'Jane Don');
INSERT INTO USERS VALUES (3, 'Alice Jones');
INSERT INTO USERS VALUES (4, 'Lisa Romero');
------------------------------------------
-- INSERT INTO TRAINING_DETAILS --
INSERT INTO TRAINING_DETAILS VALUES (1, 1, 1, TO_DATE('2015-08-02', 'YYYY-MM-DD'));
INSERT INTO TRAINING_DETAILS VALUES (2, 2, 1, TO_DATE('2015-08-03', 'YYYY-MM-DD'));
INSERT INTO TRAINING_DETAILS VALUES (3, 3, 2, TO_DATE('2015-08-02', 'YYYY-MM-DD'));
INSERT INTO TRAINING_DETAILS VALUES (4, 4, 2, TO_DATE('2015-08-04', 'YYYY-MM-DD'));
INSERT INTO TRAINING_DETAILS VALUES (5, 2, 2, TO_DATE('2015-08-03', 'YYYY-MM-DD'));
INSERT INTO TRAINING_DETAILS VALUES (6, 1, 1, TO_DATE('2015-08-02', 'YYYY-MM-DD'));
INSERT INTO TRAINING_DETAILS VALUES (7, 3, 2, TO_DATE('2015-08-04', 'YYYY-MM-DD'));
INSERT INTO TRAINING_DETAILS VALUES (8, 4, 3, TO_DATE('2015-08-03', 'YYYY-MM-DD'));
INSERT INTO TRAINING_DETAILS VALUES (9, 1, 4, TO_DATE('2015-08-03', 'YYYY-MM-DD'));
INSERT INTO TRAINING_DETAILS VALUES (10, 3, 1, TO_DATE('2015-08-02', 'YYYY-MM-DD'));
INSERT INTO TRAINING_DETAILS VALUES (11, 4, 2, TO_DATE('2015-08-04', 'YYYY-MM-DD'));
INSERT INTO TRAINING_DETAILS VALUES (12, 3, 2, TO_DATE('2015-08-02', 'YYYY-MM-DD'));
INSERT INTO TRAINING_DETAILS VALUES (13, 1, 1, TO_DATE('2015-08-02', 'YYYY-MM-DD'));
INSERT INTO TRAINING_DETAILS VALUES (14, 4, 3, TO_DATE('2015-08-03', 'YYYY-MM-DD'));
------------------------------------------
COMMIT;