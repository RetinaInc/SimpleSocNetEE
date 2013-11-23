package DAO;

import control.myexception.MyException;
import model.User;

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
    public boolean insert(User user) throws MyException, ClassNotFoundException, SQLException;
    public boolean update(User user);
    public boolean delete(User user) throws ClassNotFoundException, SQLException;
    public List<User> getAllUsers() throws MyException;
}
