insert into user (id, username, password, firstname, lastname) values (default, 'user', 'password', 'Test', 'User')


-- Operations
insert into operation (id, created_by_id, created_date, last_modified_by_id, last_modified_date, name) values (default, 1, TIMESTAMP '2016-01-01 12:00:00', 1, TIMESTAMP '2016-01-01 12:00:00', 'Operation 1')
insert into operation (id, created_by_id, created_date, last_modified_by_id, last_modified_date, name) values (default, 1, TIMESTAMP '2016-01-01 12:00:00', 1, TIMESTAMP '2016-01-01 12:00:00', 'Operation 2')
insert into operation (id, created_by_id, created_date, last_modified_by_id, last_modified_date, name) values (default, 1, TIMESTAMP '2016-01-01 12:00:00', 1, TIMESTAMP '2016-01-01 12:00:00', 'Operation 3')


insert into location (id, created_by_id, created_date, last_modified_by_id, last_modified_date, location_number, name) values (default, 1, TIMESTAMP '2016-01-01 12:00:00', 1, TIMESTAMP '2016-01-01 12:00:00', 'LOCA', 'Location A')
insert into location (id, created_by_id, created_date, last_modified_by_id, last_modified_date, location_number, name) values (default, 1, TIMESTAMP '2016-01-01 12:00:00', 1, TIMESTAMP '2016-01-01 12:00:00', 'LOCB', 'Location B')
insert into location (id, created_by_id, created_date, last_modified_by_id, last_modified_date, location_number, name) values (default, 1, TIMESTAMP '2016-01-01 12:00:00', 1, TIMESTAMP '2016-01-01 12:00:00', 'LOCC', 'Location C')


insert into device (device_id, serial_number, id) values (default, '0000000001', '01')
insert into device (device_id, serial_number, id) values (default, '0000000002', '02')
insert into device (device_id, serial_number, id) values (default, '0000000003', '03')


insert into work_event (id, created_by_id, created_date, last_modified_by_id, last_modified_date, device_id, location_id, operation_id, time_of, type) values (default, 1, TIMESTAMP '2016-01-01 12:00:00', 1, TIMESTAMP '2016-01-01 12:00:00', 1, 1, 1, TIMESTAMP '2016-01-01 12:00:00', 'Start')
insert into work_event (id, created_by_id, created_date, last_modified_by_id, last_modified_date, device_id, location_id, operation_id, time_of, type) values (default, 1, TIMESTAMP '2016-01-01 12:00:00', 1, TIMESTAMP '2016-01-01 12:00:00', 1, 2, 2, TIMESTAMP '2016-01-01 13:00:00', 'Start')
insert into work_event (id, created_by_id, created_date, last_modified_by_id, last_modified_date, device_id, location_id, operation_id, time_of, type) values (default, 1, TIMESTAMP '2016-01-01 12:00:00', 1, TIMESTAMP '2016-01-01 12:00:00', 1, 3, 3, TIMESTAMP '2016-01-01 14:00:00', 'Start')
