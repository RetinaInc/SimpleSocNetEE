package SocNET.publicDAO;

import SocNET.myexception.MyException;
import SocNET.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 11/15/13
 * Time: 10:34 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAOInterface {
    public Boolean insert(User user) throws MyException;
    public Boolean delete(User user) throws MyException;
    public List<User> getAllUsers() throws MyException;
    public User getUserObj(String email,String password) throws MyException;
    public Boolean getUser(String email,String password) throws MyException;
    public String getUsernameByID (int userID) throws MyException;
    public Boolean isExistEmail(String email) throws MyException;
}
