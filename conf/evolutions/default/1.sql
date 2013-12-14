# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table event (
  event_id                  integer auto_increment not null,
  type                      varchar(255) not null,
  time                      timestamp not null,
  constraint pk_event primary key (event_id))
;

create table graduate (
  graduation_id             bigint auto_increment not null,
  student_user_id           integer,
  timetable_entry_timetable_entry_id bigint,
  grade_value               integer not null,
  grade_annotation          varchar(255),
  constraint pk_graduate primary key (graduation_id))
;

create table group (
  group_id                  integer auto_increment not null,
  name                      varchar(255) not null,
  constraint pk_group primary key (group_id))
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
  timetable_entry_id        bigint auto_increment not null,
  time                      timestamp not null,
  group_group_id            integer,
  teacher_user_id           integer,
  subject_subject_id        integer,
  timetable_entry           bigint,
  constraint pk_timetable_entry primary key (timetable_entry_id))
;

create table user (
  user_type                 varchar(31) not null,
  user_id                   integer auto_increment not null,
  login                     varchar(255) not null,
  name                      varchar(255) not null,
  surname                   varchar(255) not null,
  password                  varchar(255) not null,
  student_id                integer not null,
  headmaster_id             integer not null,
  teacher_id                integer not null,
  constraint pk_user primary key (user_id))
;

alter table graduate add constraint fk_graduate_student_1 foreign key (student_user_id) references user (user_id) on delete restrict on update restrict;
create index ix_graduate_student_1 on graduate (student_user_id);
alter table graduate add constraint fk_graduate_timetable_entry_2 foreign key (timetable_entry_timetable_entry_id) references timetable_entry (timetable_entry_id) on delete restrict on update restrict;
create index ix_graduate_timetable_entry_2 on graduate (timetable_entry_timetable_entry_id);
alter table timetable_entry add constraint fk_timetable_entry_group_3 foreign key (group_group_id) references group (group_id) on delete restrict on update restrict;
create index ix_timetable_entry_group_3 on timetable_entry (group_group_id);
alter table timetable_entry add constraint fk_timetable_entry_teacher_4 foreign key (teacher_user_id) references user (user_id) on delete restrict on update restrict;
create index ix_timetable_entry_teacher_4 on timetable_entry (teacher_user_id);
alter table timetable_entry add constraint fk_timetable_entry_subject_5 foreign key (subject_subject_id) references subject (subject_id) on delete restrict on update restrict;
create index ix_timetable_entry_subject_5 on timetable_entry (subject_subject_id);
alter table timetable_entry add constraint fk_timetable_entry_homework_6 foreign key (timetable_entry) references homework (homework_id) on delete restrict on update restrict;
create index ix_timetable_entry_homework_6 on timetable_entry (timetable_entry);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists event;

drop table if exists graduate;

drop table if exists group;

drop table if exists homework;

drop table if exists subject;

drop table if exists timetable_entry;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

