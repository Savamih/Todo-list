create table todolist(
  task_id int null AUTO_INCREMENT,
  description text,
  create_date date,
  due_date date,
  done BOOLEAN,
  PRIMARY KEY (task_id)
);

