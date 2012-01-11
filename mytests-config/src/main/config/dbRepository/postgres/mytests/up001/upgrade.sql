create sequence sc_mytests_contact_id_seq;

ALTER TABLE sc_mytests_contact RENAME COLUMN service TO department;
ALTER TABLE sc_mytests_contact ADD COLUMN componentId varchar(50) not null;