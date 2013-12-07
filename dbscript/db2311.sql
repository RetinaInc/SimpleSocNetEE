USE SocNet;
CREATE TABlE MESSAGE
(
  id_mess int not NULL AUTO_INCREMENT ,
  title varchar (255) NOT NULL,
  bodymess varchar (255) NOT NULL,
  create_date varchar(255) NOT NULL,
  id_user int not NULL,
  PRIMARY KEY (id_mess),
  FOREIGN KEY (id_user) REFERENCES USERS(id_user)
);

CREATE TABlE GROUPS
(
  id_group int not NULL AUTO_INCREMENT ,
  group_name varchar (255) NOT NULL,
  desctiption varchar (255) NOT NULL,
  id_user int not NULL,
  PRIMARY KEY (id_group),
  FOREIGN KEY (id_user) REFERENCES USERS(id_user)
);

CREATE TABlE GROUP_PARTICIPANT
(
  id_gp int not NULL AUTO_INCREMENT ,
  id_user int not NULL,
  id_group int not NULL,
  PRIMARY KEY (id_gp),
  FOREIGN KEY (id_user) REFERENCES USERS(id_user),
  FOREIGN KEY (id_group) REFERENCES GROUPS(id_group)
);
