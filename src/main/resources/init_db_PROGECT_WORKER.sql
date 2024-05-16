CREATE TABLE world.progect_worker
(
    progect_id int(11),
    worker_id   int(11),
    PRIMARY KEY (progect_id, worker_id),
    FOREIGN KEY (progect_id) REFERENCES progect (id),
    FOREIGN KEY (worker_id) REFERENCES worker (id)
);