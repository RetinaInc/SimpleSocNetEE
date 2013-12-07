USE SocNet;
CREATE TABlE USERS
(
  id_user int not NULL AUTO_INCREMENT ,
  lastname varchar (255) NOT NULL,
  firstname varchar (255) NOT NULL,
  email varchar(255) NOT NULL,
  password varchar (255) NOT NULL,
  PRIMARY KEY (id_user)
);

CREATE TABlE Message
(
  id_mess int not NULL AUTO_INCREMENT ,
  Title varchar (255) NOT NULL,
  bodymess varchar (255) NOT NULL,
  create_date varchar(255) NOT NULL,
  id_user int not NULL,
  PRIMARY KEY (id_mess),
  FOREIGN KEY (id_user) REFERENCES USERS(id_user)
);