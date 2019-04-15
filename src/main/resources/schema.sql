DROP TABLE IF EXISTS mst_employee;
DROP TABLE IF EXISTS mst_password;
DROP TABLE IF EXISTS mst_role;
DROP TABLE IF EXISTS mst_news;

-- 従業員マスタ
CREATE TABLE mst_employee
(
	employee_id varchar(10) NOT NULL,
	employee_last_name varchar(50),
	employee_first_name varchar(50),
	role_id varchar(20) NOT NULL,
  version int,
  insert_user varchar(20) ,
  insert_date timestamp ,
  update_user varchar(20) ,
  update_date timestamp,
	PRIMARY KEY (employee_id)
);


-- パスワードマスタ
CREATE TABLE mst_password
(
  mst_password_id int NOT NULL,
  employee_id varchar(10) NOT NULL,
  password varchar(256),
  generation varchar(2),
  version int,
  insert_user varchar(20) ,
  insert_date timestamp ,
  update_user varchar(20) ,
  update_date timestamp,
  PRIMARY KEY (mst_password_id),
  UNIQUE (employee_id, generation)
);


-- 権限マスタ
CREATE TABLE mst_role
(
  role_id varchar(20) NOT NULL,
  role_name varchar(100),
  version int,
  insert_user varchar(20) ,
  insert_date timestamp ,
  update_user varchar(20) ,
  update_date timestamp,
  PRIMARY KEY (role_id)
);


-- お知らせマスタ
CREATE TABLE mst_news
(
  mst_news_id SERIAL,
  role_id varchar(10) NOT NULL,
  subject varchar(2000),
  url varchar(512),
  version int,
  insert_user varchar(20) ,
  insert_date timestamp ,
  update_user varchar(20) ,
  update_date timestamp,
  PRIMARY KEY (mst_news_id)
);
