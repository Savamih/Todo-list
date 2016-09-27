create table task(
  task_id int not null AUTO_INCREMENT,
  description text not null,
  due_time TIMESTAMP not null,
  iswasted BOOLEAN not null,
  isdone BOOLEAN NOT NULL ,
  PRIMARY KEY (task_id)
);

