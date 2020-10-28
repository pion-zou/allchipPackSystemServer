1. 创建数据库

  ```sql
  create database allchip;
  ```

2. 创建表

   创建订单

   ```mysql
   use allchip;
   CREATE TABLE contract (
     id int(11) NOT NULL AUTO_INCREMENT,
     number varchar(50),
     creator varchar(30),
     remark varchar(300),
     create_time TIMESTAMP,
     state varchar(10),
     update_time TIMESTAMP,
     editor varchar(30),
     publish_time varchar(30),
     PRIMARY KEY (id)
   )ENGINE=InnoDB DEFAULT CHARSET=UTF8;
   
   ```

   创建货物表

   ```mysql
   CREATE TABLE goods (
     id int(11) NOT NULL AUTO_INCREMENT,
     contract_id int(10),
     contract_number varchar(50),
     number int(10),
     type varchar(50),
     remark varchar(300),
     create_time TIMESTAMP(13),
     PRIMARY KEY (id)
   )ENGINE=InnoDB DEFAULT CHARSET=UTF8;
   ```

   

3. 插入数据

   ```mysql
   insert into contract values(null,'no.zero' , 'zou' , 'test' , now());
   ```

   

