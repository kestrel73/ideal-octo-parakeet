insert into user (id, username, password, firstname, lastname) values (default, 'user', 'password', 'Test', 'User')


-- Operations
insert into operation (id, created_by_id, created_date, last_modified_by_id, last_modified_date, name) values (default, 1, TIMESTAMP '2016-01-01 12:00:00', 1, TIMESTAMP '2016-01-01 12:00:00', 'Operation 1')
insert into operation (id, created_by_id, created_date, last_modified_by_id, last_modified_date, name) values (default, 1, TIMESTAMP '2016-01-01 12:00:00', 1, TIMESTAMP '2016-01-01 12:00:00', 'Operation 2')