DROP TABLE IF EXISTS rhum;

CREATE TABLE rhum(
	id Integer auto_increment primary key, 
	rhum_name varchar(40), 
	alc_deg varchar(40), 
	origin varchar(40)
);

INSERT INTO rhum(rhum_name, alc_deg, origin) VALUES
  ('Clement', '50', 'Martinique'),
  ('Karukera', '50', 'Guadeloupe'),
  ('Don Papa', '45', 'Phillipines');