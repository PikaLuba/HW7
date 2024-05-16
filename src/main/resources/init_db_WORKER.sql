CREATE TABLE world.worker (
  id int(11) NOT NULL,
  name varchar(1000) NOT NULL,
  birthday date DEFAULT NULL,
  level varchar(7) NOT NULL,
  salary int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  CHECK (birthday > '1900-01-01'),
  CHECK (salary>=100 and salary<=100000),
  CHECK (level IN ('Trainee', 'Junior', 'Middle', 'Senior'))
);
