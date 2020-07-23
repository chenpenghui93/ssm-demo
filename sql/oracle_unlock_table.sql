-- 查看被锁表
select b.owner, b.object_name, a.session_id, a.locked_mode
from v$locked_object a,
     dba_objects b
where b.object_id = a.object_id;

-- 查看被缩表的sid、serial
select b.username, b.sid, b.serial#, logon_time
from v$locked_object a,
     v$session b
where a.session_id = b.sid
order by b.logon_time;

-- sid,serial
alter system kill session '547,36734';