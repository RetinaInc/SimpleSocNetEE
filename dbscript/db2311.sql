USE SocNet;
CREATE TABlE MESSAGE
(
  idMess int not NULL AUTO_INCREMENT ,
  title varchar (255) NOT NULL,
  bodymess varchar (255) NOT NULL,
  createDate varchar(255) NOT NULL,
  idUser int not NULL,
  idGroup int not NULL,
  PRIMARY KEY (idMess),
  FOREIGN KEY (idUser) REFERENCES USERS(idUser),
  FOREIGN KEY (idGroup) REFERENCES GROUPS(idGroup)
);

CREATE TABlE GROUPS
(
  idGroup int not NULL AUTO_INCREMENT ,
  group_name varchar (255) NOT NULL,
  desctiption varchar (255) NOT NULL,
  idUser int not NULL,
  PRIMARY KEY (idGroup),
  FOREIGN KEY (idUser) REFERENCES USERS(idUser)
);

CREATE TABlE GROUP_PARTICIPANT
(
  id_gp int not NULL AUTO_INCREMENT ,
  idUser int not NULL,
  idGroup int not NULL,
  PRIMARY KEY (id_gp),
  FOREIGN KEY (idUser) REFERENCES USERS(idUser),
  FOREIGN KEY (idGroup) REFERENCES GROUPS(idGroup)
);
