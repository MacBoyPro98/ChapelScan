-- auto-generated definition
create table scans
(
  id         int                                not null,
  fName      varchar(255)                       null,
  lName      varchar(255)                       null,
  CREATED_AT datetime default CURRENT_TIMESTAMP not null,
  UPDATED_AT datetime                           null,
  PHOTO      longtext                           null,
  constraint current_scans_id_uindex
    unique (id)
);

-- auto-generated definition
create table students
(
  fName   varchar(255) not null,
  lName   varchar(255) not null,
  CARD_ID int          not null,
  STU_ID  int          not null,
  PHOTO   longtext     null,
  constraint students_CARD_ID_uindex
    unique (CARD_ID),
  constraint students_STU_ID_uindex
    unique (STU_ID)
);