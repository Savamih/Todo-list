create table task(
  task_id int not null AUTO_INCREMENT,
  description text,
  due_time TIME,
  iswasted BOOLEAN,
  isdone BOOLEAN,
  PRIMARY KEY (task_id)
);

