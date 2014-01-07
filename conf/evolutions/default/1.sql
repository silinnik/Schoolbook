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

create table mgrade (
  id                        bigint auto_increment not null,
  student_id                bigint,
  timetable_entry_id        bigint,
  grade_value               integer not null,
  grade_annotation          varchar(255),
  constraint pk_mgrade primary key (id))
;

create table mgroup (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  mentor_id                 bigint,
  constraint pk_mgroup primary key (id))
;

create table mhomework (
  id                        bigint auto_increment not null,
  timetable_entry_id        bigint,
  homework_text             varchar(255) not null,
  constraint pk_mhomework primary key (id))
;

create table msubject (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_msubject primary key (id))
;

create table mtimetable_entry (
  id                        bigint auto_increment not null,
  time                      bigint,
  group_id                  bigint,
  teacher_id                bigint,
  subject_id                bigint,
  constraint pk_mtimetable_entry primary key (id))
;

create table muser (
  user_type                 varchar(31) not null,
  id                        bigint auto_increment not null,
  login                     varchar(255) not null,
  password                  varchar(255) not null,
  first_name                varchar(255) not null,
  last_name                 varchar(255) not null,
  group_id                  bigint,
  constraint uq_muser_login unique (login),
  constraint pk_muser primary key (id))
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
  group_id                  integer,
  teacher                   integer,
  subject                   integer,
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
  group_id                  integer,
  teacher_id                integer,
  constraint pk_user primary key (user_id))
;

alter table grade add constraint fk_grade_student_1 foreign key (student_user_id) references user (user_id) on delete restrict on update restrict;
create index ix_grade_student_1 on grade (student_user_id);
alter table grade add constraint fk_grade_timetable_entry_2 foreign key (timetable_entry_timetable_entry_id) references timetable_entry (timetable_entry_id) on delete restrict on update restrict;
create index ix_grade_timetable_entry_2 on grade (timetable_entry_timetable_entry_id);
alter table mgrade add constraint fk_mgrade_student_3 foreign key (student_id) references muser (id) on delete restrict on update restrict;
create index ix_mgrade_student_3 on mgrade (student_id);
alter table mgrade add constraint fk_mgrade_timetable_entry_4 foreign key (timetable_entry_id) references mtimetable_entry (id) on delete restrict on update restrict;
create index ix_mgrade_timetable_entry_4 on mgrade (timetable_entry_id);
alter table mgroup add constraint fk_mgroup_mentor_5 foreign key (mentor_id) references muser (id) on delete restrict on update restrict;
create index ix_mgroup_mentor_5 on mgroup (mentor_id);
alter table mhomework add constraint fk_mhomework_timetable_entry_6 foreign key (timetable_entry_id) references mtimetable_entry (id) on delete restrict on update restrict;
create index ix_mhomework_timetable_entry_6 on mhomework (timetable_entry_id);
alter table mtimetable_entry add constraint fk_mtimetable_entry_group_7 foreign key (group_id) references mgroup (id) on delete restrict on update restrict;
create index ix_mtimetable_entry_group_7 on mtimetable_entry (group_id);
alter table mtimetable_entry add constraint fk_mtimetable_entry_teacher_8 foreign key (teacher_id) references muser (id) on delete restrict on update restrict;
create index ix_mtimetable_entry_teacher_8 on mtimetable_entry (teacher_id);
alter table mtimetable_entry add constraint fk_mtimetable_entry_subject_9 foreign key (subject_id) references msubject (id) on delete restrict on update restrict;
create index ix_mtimetable_entry_subject_9 on mtimetable_entry (subject_id);
alter table muser add constraint fk_muser_group_10 foreign key (group_id) references mgroup (id) on delete restrict on update restrict;
create index ix_muser_group_10 on muser (group_id);
alter table muser add constraint fk_muser_group_11 foreign key (group_id) references mgroup (id) on delete restrict on update restrict;
create index ix_muser_group_11 on muser (group_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table event;

drop table grade;

drop table GROUPP;

drop table homework;

drop table mgrade;

drop table mgroup;

drop table mhomework;

drop table msubject;

drop table mtimetable_entry;

drop table muser;

drop table subject;

drop table timetable_entry;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

