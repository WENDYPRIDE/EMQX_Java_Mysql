create table user
(
    id   int         not null
        primary key,
    uname varchar(30) null,
    pwd  varchar(30) null
);

INSERT INTO exp_4.user (id, uname, pwd) VALUES (102, 'b', '123456');
INSERT INTO exp_4.user (id, uname, pwd) VALUES (103, 'b', '3456');
INSERT INTO exp_4.user (id, uname, pwd) VALUES (104, 'c', '1256');
INSERT INTO exp_4.user (id, uname, pwd) VALUES (105, 's', '123456');
INSERT INTO exp_4.user (id, uname, pwd) VALUES (106, 'r', '1256');
INSERT INTO exp_4.user (id, uname, pwd) VALUES (107, 'y', '123456');
INSERT INTO exp_4.user (id, uname, pwd) VALUES (1013, '2222', 'www');