-- 远程连接
mysql -u root -p -h x.x.x.x [-P 3306] [-D test1]

-- 创建用户
CREATE USER 'test1'@'localhost' IDENTIFIED BY '123456';
CREATE USER 'test1'@'%' IDENTIFIED BY '123456';

-- 创建数据库
CREATE DATABASE test1_db DEFAULT CHARSET utf8 COLLATE utf8_bin;

-- 授权用户
GRANT ALL PRIVILEGES ON test1_db.* TO 'test1'@'localhost' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON test1_db.* TO 'test1'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

-- 删除用户
DELETE FROM mysql.user WHERE USER='test1' AND HOST='localhost';
FLUSH PRIVILEGES;
DROP DATABASE test1;
DROP USER test1@'%';
DROP USER test1@'localhost';

-- 修改密码
ALTER USER 'test1'@'localhost' IDENTIFIED BY 'new password';
ALTER USER 'test1'@'localhost' IDENTIFIED BY 'new password';
-- 查询密码策略
SHOW VARIABLES LIKE 'validate_password%';