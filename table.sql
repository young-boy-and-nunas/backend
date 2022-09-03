create table auto_cheer (auto_cheer_seq bigint not null auto_increment, contents varchar(255), img_url varchar(255), primary key (auto_cheer_seq)) engine=InnoDB;
create table cheer (cheer_seq bigint not null auto_increment, audio_url varchar(255), contents varchar(2040), img_url varchar(255), user_seq bigint not null, worry_seq bigint not null, primary key (cheer_seq)) engine=InnoDB;
create table user (user_seq bigint not null auto_increment, id varchar(255), lucky_point integer not null, password varchar(255), state integer not null, primary key (user_seq)) engine=InnoDB;
create table worry (worry_seq bigint not null auto_increment, contents varchar(2040), img_url varchar(255), user_seq bigint not null, primary key (worry_seq)) engine=InnoDB;
alter table cheer add constraint FKoipp9vxdf4sm45g6ax9n623lv foreign key (user_seq) references user (user_seq);
alter table cheer add constraint FK1yke747jsvcppbps9khevet9j foreign key (worry_seq) references worry (worry_seq);
alter table worry add constraint FKh9fedck89pnfr0vs77n8mm93i foreign key (user_seq) references user (user_seq);