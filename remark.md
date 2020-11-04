1. 创建数据库

  ```sql
  create database allchip;
  ```

2. 创建表

   创建订单

   ```mysql
   use allchip;
   CREATE TABLE `contract` (
     `id` int NOT NULL AUTO_INCREMENT,
     `number` varchar(50) DEFAULT NULL,
     `creator` varchar(30) DEFAULT NULL,
     `remark` varchar(300) DEFAULT NULL,
     `create_time` timestamp NULL DEFAULT NULL,
     `state` varchar(10) DEFAULT NULL,
     `update_time` timestamp NULL DEFAULT NULL,
     `editor` varchar(30) DEFAULT NULL,
     `publish_time` varchar(30) DEFAULT NULL,
     PRIMARY KEY (`id`)
   ) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
   
   ```

   创建货物表

   ```mysql
   CREATE TABLE `goods` (
     `id` int NOT NULL AUTO_INCREMENT,
     `item_index` varchar(50) DEFAULT NULL,
     `number` varchar(50) DEFAULT NULL,
     `type` varchar(50) DEFAULT NULL,
     `creator` varchar(30) DEFAULT NULL,
     `remark` varchar(300) DEFAULT NULL,
     `count` int DEFAULT NULL,
     `package_count` int DEFAULT NULL,
     `package_time` timestamp NULL DEFAULT NULL,
     `year` varchar(10) DEFAULT NULL,
     `manufacturer` varchar(50) DEFAULT NULL,
     `package` varchar(50) DEFAULT NULL,
     `unit_price` float(8,3) DEFAULT NULL,
     `total_price` float(10,3) DEFAULT NULL,
     PRIMARY KEY (`id`)
   ) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8
   ```

   创建用户表

   ```mysql
   CREATE TABLE `user` (
     `id` int NOT NULL AUTO_INCREMENT,
     `name` varchar(255) NOT NULL,
     `password` varchar(50) NOT NULL,
     PRIMARY KEY (`id`)
   ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci 
   ```

   

3. 插入数据

   ```mysql
   insert into user set name="jane" , password="123456";
   
insert into user (`name` , `password`) values("jane" , "123456");
   ```
   
   

 4.Springboot打包、运行

```
mvn install
java -jar target/pack-0.0.1-SNAPSHOT.jar
```

