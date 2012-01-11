create sequence sc_mytests_contact_id_seq;

create table sc_mytests_contact (
    pubId		int		not null,
    lastName		varchar(50)     not null,
    firstName		varchar(50)     not null,
    department		varchar(50)     not null,
    componentId     varchar(50)     not null
);

alter table sc_mytests_contact
        add constraint pk_mytests_contact
        primary key (pubId);