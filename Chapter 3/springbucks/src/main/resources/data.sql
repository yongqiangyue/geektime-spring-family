-- 初始化作者
insert into t_publisher (name, create_time, update_time) values ('tyler', now(), now());

INSERT INTO t_publisher(name, create_time, update_time) VALUES ('zhangsc', now(), now());
INSERT INTO t_publisher(name, create_time, update_time) VALUES ('yueyq', now(), now());
-- 初始化咖啡菜单
insert into t_coffee (name, price, create_time, update_time) values ('espresso', 2000, now(), now());
INSERT INTO t_coffee (name, price, create_time, update_time) VALUES ('latte', 2500, now(), now());
insert into t_coffee (name, price, create_time, update_time) values ('capuccino', 2500, now(), now());
insert into t_coffee (name, price, create_time, update_time) values ('mocha', 3000, now(), now());
insert into t_coffee (name, price, create_time, update_time) values ('macchiato', 3000, now(), now());