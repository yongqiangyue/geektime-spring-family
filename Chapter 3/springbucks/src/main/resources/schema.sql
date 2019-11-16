--删除表
DROP TABLE t_coffee IF EXISTS;
DROP TABLE t_order IF EXISTS;
DROP TABLE t_order_coffee IF EXISTS;
-- DROP TABLE t_book IF EXISTS;
DROP TABLE t_publisher IF EXISTS;
-- DROP TABLE t_book_publisher IF EXISTS;


-- 创建测试表
-- CREATE TABLE t_book(
--     id bigint auto_increment,
--     create_time timestamp,
--     update_time timestamp,
--     name varchar(255),
--     primary key(id)
-- );

CREATE TABLE t_publisher(
    id bigint auto_increment,
    create_time timestamp,
    update_time timestamp,
    name varchar(255),
    PRIMARY key(id)
);

-- CREATE TABLE t_book_publisher(
--     book_id bigint not null,
--     publisher_id bigint not null
-- );


--创建表：t_coffee, t_order, t_order_coffee
CREATE TABLE t_coffee(
    id bigint auto_increment,
    create_time timestamp,
    update_time timestamp,
    name varchar(255),
    price bigint,
    primary key(id)
);

CREATE TABLE t_order(
    id bigint auto_increment,
    create_time timestamp,
    update_time timestamp,
    customer varchar(255),
    state integer not null,
    PRIMARY KEY(id)
);

CREATE TABLE t_order_coffee(
    coffee_order_id bigint not null,
    items_id bigint not null
);
