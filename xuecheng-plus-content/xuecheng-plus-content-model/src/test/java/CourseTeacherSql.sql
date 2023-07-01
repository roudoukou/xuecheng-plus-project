-- create table xc402_content.course_teacher
-- (
--     id           bigint auto_increment comment '主键'
--         primary key,
--     course_id    bigint        null comment '课程标识',
--     teacher_name varchar(60)   null comment '教师标识',
--     position     varchar(255)  null comment '教师职位',
--     introduction varchar(1024) null comment '教师简介',
--     photograph   varchar(1024) null comment '照片',
--     create_date  datetime      null comment '创建时间',
--     constraint courseid_teacherId_unique
--         unique (course_id, teacher_name)
-- )
--     comment '课程-教师关系表';
--


# 查询教师接口请求示例
select *
from course_teacher
where course_id in (72, 79)