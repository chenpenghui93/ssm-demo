-----------------oracle unlock table------------------------------
-- 查看被锁表
select b.owner, b.object_name, a.session_id, a.locked_mode
from v$locked_object a,
     dba_objects b
where b.object_id = a.object_id;

-- 查看被锁表的‘sid、serial’
select b.username, b.sid, b.serial#, logon_time
from v$locked_object a,
     v$session b
where a.session_id = b.sid
order by b.logon_time;

-- 参数‘sid,serial’
alter system kill session '547,36734';


-----------------oracle rollback data------------------------------
-- 查询sql执行历史确定回滚时间点
select sql_text,last_load_time from v$sql where sql_text like '%update%' order by last_load_time desc;

-- 将数据回滚至指定时间点
alter table tablename enable row movement;
flashback table tablename to timestamp to_timestamp('xxxx-xx-xx xx:xx:xx', 'yyyy-mm-dd hh24:mi:ss');