-----------------create database begin-------------------------------
-- 查询表空间路径
select tablespace_name, file_id, bytes / 1024 / 1024, file_name from dba_data_files order by file_id;
-- 创建表空间(注意修改datafile路径及名称)
create tablespace [namespace] datafile '/u01/oradata/PGDEVDB/uaadev01.dbf' size 5120 M;
-- 创建用户并默认表空间
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
-----------------create database end-------------------------------


-----------------unlock table begin-------------------------------
-- 查看被锁表
select b.owner, b.object_name, a.session_id, a.locked_mode
from v$locked_object a, dba_objects b where b.object_id = a.object_id;
-- 查看被锁表的‘sid、serial’
select b.username, b.sid, b.serial#, logon_time
from v$locked_object a, v$session b
where a.session_id = b.sid order by b.logon_time;
-- 参数‘sid,serial’
alter system kill session '547,36734';
-----------------unlock table end---------------------------------


-----------------rollback data begin------------------------------
-- 查询sql执行历史确定回滚时间点
select sql_text,last_load_time from v$sql where sql_text like '%update%' order by last_load_time desc;
-- 将数据回滚至指定时间点
alter table tablename enable row movement;
flashback table tablename to timestamp to_timestamp('xxxx-xx-xx xx:xx:xx', 'yyyy-mm-dd hh24:mi:ss');
-----------------rollback data end--------------------------------


-----------------hierarchy query begin--------------------------------
-- 查询当前级别所有父级(指定子级，父级=子级)
select t.MENU_CODE,t.PARENT_CODE from SYS_MENU t
start with t.MENU_CODE = 'release' connect by prior t.PARENT_CODE = t.MENU_CODE;
-- 查询所有子级(指定父级，子级=父级)
select t.MENU_CODE,t.PARENT_CODE from SYS_MENU t
start with t.MENU_CODE = 'gateway' connect by prior t.MENU_CODE = t.PARENT_CODE;
-----------------hierarchy query end--------------------------------