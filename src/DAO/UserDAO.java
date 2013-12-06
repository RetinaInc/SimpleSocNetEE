package DAO;

import control.myexception.MyException;
import model.User;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
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
        //Tested valid sql
        //INSERT INTO "Users" (id_user,username,email,pswd,user_type,is_blocked) values (0,'reshet','reshet.ukr@gmail.com','tratata','customer',0);
        return booleanOperation(new WrapperDBOperation<Boolean>() {
            @Override
            public Boolean doMethod(Connection dataBase) throws SQLException, MyException {
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
    public boolean update(User user) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean delete(User user) throws ClassNotFoundException, SQLException {
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
                    String lastname = results.getString(2);
                    String firstname = results.getString(3);
                    String email = results.getString(4);
                    String password = results.getString(5);

                    User user = new User(id,lastname,firstname,email,password);

                    uList.add(user);
                }
                return uList;
            }
        });
    }
}
