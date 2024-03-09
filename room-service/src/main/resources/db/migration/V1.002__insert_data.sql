INSERT INTO ROOM (NAME, CAPACITY, AMENITIES) VALUES ('Room 1', 2, 'Wi-Fi, TV');
INSERT INTO ROOM (NAME, CAPACITY, AMENITIES) VALUES ('Room 2', 4, 'Wi-Fi, TV, Mini-bar');

INSERT INTO ROOM_PRICE (TYPE, PRICE, ROOM_ID) VALUES ('STANDARD', 100, (SELECT ID FROM ROOM WHERE NAME = 'Room 1'));
INSERT INTO ROOM_PRICE (TYPE, PRICE, ROOM_ID) VALUES ('GOLD', 70, (SELECT ID FROM ROOM WHERE NAME = 'Room 1'));
INSERT INTO ROOM_PRICE (TYPE, PRICE, ROOM_ID) VALUES ('PLATINUM', 50, (SELECT ID FROM ROOM WHERE NAME = 'Room 1'));

INSERT INTO ROOM_PRICE (TYPE, PRICE, ROOM_ID) VALUES ('STANDARD', 200, (SELECT ID FROM ROOM WHERE NAME = 'Room 2'));
INSERT INTO ROOM_PRICE (TYPE, PRICE, ROOM_ID) VALUES ('GOLD', 150, (SELECT ID FROM ROOM WHERE NAME = 'Room 2'));
INSERT INTO ROOM_PRICE (TYPE, PRICE, ROOM_ID) VALUES ('PLATINUM', 100, (SELECT ID FROM ROOM WHERE NAME = 'Room 2'));