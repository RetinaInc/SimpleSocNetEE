package SocNET.DAO;

import SocNET.myexception.MyException;
import SocNET.model.User;
import SocNET.publicDAO.UserDAOInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 11/15/13
 * Time: 10:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDAO extends AbstractDBConn implements UserDAOInterface {

    @Override
    public boolean insert(final User user) throws MyException {

        return booleanOperation(new WrapperDBOperation<Boolean>() {
            @Override
            public Boolean doMethod(Connection dataBase) throws SQLException, MyException {
                PreparedStatement prep = dataBase.prepareStatement(
                        "INSERT INTO USERS (login,email,password) values (?,?,?)"
                );
                //NamedParameterStatement p = new NamedParameterStatement(con, query);
                // prep.setInt(1,11);
                prep.setString(1,user.getUsername());
                prep.setString(2, user.getEmail());
                prep.setString(3, user.getPassword());
                //String str = prep.;

                prep.executeUpdate();
                return true;
            }
        });


    }

 /*   @Override
    public boolean insert(final User user) throws MyException, ClassNotFoundException, SQLException {
        Connection dataBase = null;

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost/SocNet";
        dataBase = DriverManager.getConnection(url, "root", "1111");

                PreparedStatement prep = dataBase.prepareStatement(
                        "INSERT INTO USERS (lastname,firstname,email,password) values (?,?,?,?)"
                );
                //NamedParameterStatement p = new NamedParameterStatement(con, query);
                // prep.setInt(1,11);
                prep.setString(1, user.getLastname());
                prep.setString(2, user.getFirstname());
                prep.setString(3, user.getEmail());
                prep.setString(4, user.getPassword());
                //String str = prep.;

                prep.executeUpdate();

                return true;




    }*/



    @Override
    public boolean delete(User user) throws MyException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<User> getAllUsers() throws MyException {

        return booleanOperation(new WrapperDBOperation<List<User>>() {

            @Override
            public List<User> doMethod(Connection dataBase) throws MyException, SQLException {
                PreparedStatement prep = dataBase.prepareStatement(
                        "SELECT * FROM USERS;"
                );

                java.sql.ResultSet results = prep.executeQuery();
                List<User> uList = new ArrayList<User>();
                while (results.next()) {

                    Integer id = results.getInt(1);
                    String username = results.getString(2);
                    String email = results.getString(3);
                    String password = results.getString(4);

                    User user = new User(id,username,email,password);

                    uList.add(user);
                }
                return uList;
            }
        });
    }

    public boolean getUser(final String email, final String password) throws MyException {
        return booleanOperation(new WrapperDBOperation<Boolean>() {

            @Override
            public Boolean doMethod(Connection dataBase) throws MyException, SQLException {
                PreparedStatement prep = dataBase.prepareStatement(
                        "SELECT COUNT(*) FROM USERS WHERE email=? AND password=?"
                );
                prep.setString(1, email);
                prep.setString(2, password);

                java.sql.ResultSet res = prep.executeQuery();
                res.next();
                int exist = res.getInt(1);
                boolean answer = false;
                if (exist != 0) {
                    answer = true;
                }

                return answer;

            }
        });

    }

    public User getUserObj(final String email, final String password) throws MyException {
        return booleanOperation(new WrapperDBOperation<User>() {

            @Override
            public User doMethod(Connection dataBase) throws MyException, SQLException {
                PreparedStatement prep = dataBase.prepareStatement(
                        "SELECT id_user,username,email,password FROM USERS WHERE email=? AND password=?"
                );
                prep.setString(1, email);
                prep.setString(2, password);

                java.sql.ResultSet res = prep.executeQuery();
                res.next();
                int id = res.getInt(1);
                boolean answer = false;
                if (id > 0) {
                    //answer = true;
                    String uname = res.getString(2);
                    String email = res.getString(3);
                    String pswd = res.getString(4);
                    User user = new User(id, uname, email, pswd);
                    return user;
                }

                return null;

            }
        });

    }

}
