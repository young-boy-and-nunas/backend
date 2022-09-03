create table cheer (cheer_seq bigint not null auto_increment, audio_url varchar(255), contents varchar(2040), img_url varchar(255), read_check bit not null, user_seq bigint not null, worry_seq bigint not null, primary key (cheer_seq)) engine=InnoDB;
create table history (history_seq bigint not null auto_increment, user_seq bigint not null, worry_seq bigint not null, primary key (history_seq)) engine=InnoDB;
create table user (user_seq bigint not null auto_increment, id varchar(255), lucky_point integer not null, password varchar(255), state integer not null, primary key (user_seq)) engine=InnoDB;
create table worry (worry_seq bigint not null auto_increment, contents varchar(2040), img_url varchar(255), user_seq bigint not null, primary key (worry_seq)) engine=InnoDB;
alter table cheer add constraint FKoipp9vxdf4sm45g6ax9n623lv foreign key (user_seq) references user (user_seq);
alter table cheer add constraint FK1yke747jsvcppbps9khevet9j foreign key (worry_seq) references worry (worry_seq);
alter table history add constraint FK77dwqgwgpbfop6vc38blujm0p foreign key (user_seq) references user (user_seq);
alter table history add constraint FKa6x74b1irh90r4emtlnncyptb foreign key (worry_seq) references worry (worry_seq);
alter table worry add constraint FKh9fedck89pnfr0vs77n8mm93i foreign key (user_seq) references user (user_seq);