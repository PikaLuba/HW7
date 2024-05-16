CREATE TABLE world.progect
(
    id         int(11) NOT NULL,
    client_id  int(11),
    start_date   DATE,
    finish_date   DATE,
    name VARCHAR(1000) ,
    PRIMARY KEY (id),
    FOREIGN KEY (client_id) REFERENCES client (id)
);
