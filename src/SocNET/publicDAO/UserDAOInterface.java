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
    public boolean insert(User user) throws MyException;
    public boolean delete(User user) throws MyException;
    public List<User> getAllUsers() throws MyException;
    public User getUserObj(final String email, final String password) throws MyException;
    public boolean getUser(final String email, final String password) throws MyException;
}
