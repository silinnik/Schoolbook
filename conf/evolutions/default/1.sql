# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table event (
  event_id                  integer auto_increment not null,
  type                      varchar(255) not null,
  time                      datetime not null,
  constraint pk_event primary key (event_id))
;

create table grade (
  grade_id                  bigint auto_increment not null,
  student_user_id           integer,
  timetable_entry_timetable_entry_id integer,
  grade_value               integer not null,
  grade_annotation          varchar(255),
  week                      integer not null,
  constraint pk_grade primary key (grade_id))
;

create table GROUPP (
  group_id                  integer auto_increment not null,
  name                      varchar(255) not null,
  constraint pk_GROUPP primary key (group_id))
;

create table homework (
  homework_id               bigint auto_increment not null,
  homework_text             varchar(255) not null,
  constraint pk_homework primary key (homework_id))
;

create table subject (
  subject_id                integer auto_increment not null,
  name                      varchar(255) not null,
  constraint pk_subject primary key (subject_id))
;

create table timetable_entry (
  timetable_entry_id        integer auto_increment not null,
  cal                       datetime,
  day                       integer not null,
  number                    integer not null,
  group_group_id            integer,
  teacher_user_id           integer,
  subject_subject_id        integer,
  constraint pk_timetable_entry primary key (timetable_entry_id))
;

create table user (
  user_type                 varchar(31) not null,
  user_id                   integer auto_increment not null,
  login                     varchar(255) not null,
  name                      varchar(255) not null,
  surname                   varchar(255) not null,
  password                  varchar(255) not null,
  headmaster_id             integer,
  teacher_id                integer,
  student_id                integer,
  group_id                  integer,
  constraint pk_user primary key (user_id))
;

alter table grade add constraint fk_grade_student_1 foreign key (student_user_id) references user (user_id) on delete restrict on update restrict;
create index ix_grade_student_1 on grade (student_user_id);
alter table grade add constraint fk_grade_timetable_entry_2 foreign key (timetable_entry_timetable_entry_id) references timetable_entry (timetable_entry_id) on delete restrict on update restrict;
create index ix_grade_timetable_entry_2 on grade (timetable_entry_timetable_entry_id);
alter table timetable_entry add constraint fk_timetable_entry_group_3 foreign key (group_group_id) references GROUPP (group_id) on delete restrict on update restrict;
create index ix_timetable_entry_group_3 on timetable_entry (group_group_id);
alter table timetable_entry add constraint fk_timetable_entry_teacher_4 foreign key (teacher_user_id) references user (user_id) on delete restrict on update restrict;
create index ix_timetable_entry_teacher_4 on timetable_entry (teacher_user_id);
alter table timetable_entry add constraint fk_timetable_entry_subject_5 foreign key (subject_subject_id) references subject (subject_id) on delete restrict on update restrict;
create index ix_timetable_entry_subject_5 on timetable_entry (subject_subject_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table event;

drop table grade;

drop table GROUPP;

drop table homework;

drop table subject;

drop table timetable_entry;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

