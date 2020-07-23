-- 查询表空间路径
select tablespace_name, file_id, bytes / 1024 / 1024, file_name from dba_data_files order by file_id;
-- 创建表空间
create tablespace [namespace] datafile '/u01/oradata/PGDEVDB/uaadev01.dbf' size 5120 M;
-- 创建用户并默认 表空间
create user [username] identified by [password] default tablespace [namespace];
-- 给用户权限
grant connect to [username];
grant resource to [username];
grant select_catalog_role to [username];
grant create any sequence to [username];
grant create any table to [username];
grant create any view to [username];
grant create table to [username];
grant create tablespace to [username];
grant create view to [username];
grant delete any table to [username];
grant execute any procedure to [username];
grant insert any table to [username];
grant select any dictionary to [username];
grant select any table to [username];
grant unlimited tablespace to [username];
grant update any table to [username];
grant debug connect session to [username];