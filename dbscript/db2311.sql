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
/*example insert  id db
INSERT INTO USERS(lastname,firstname,email,password) values("Vasya","Pupkin","vpupkin@gmail.com","123456");*/
