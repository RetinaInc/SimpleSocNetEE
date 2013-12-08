package SocNET.publicDAO;

import SocNET.model.Groups;
import SocNET.model.User;
import SocNET.myexception.MyException;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/8/13
 * Time: 1:09 AM
 * To change this template use File | Settings | File Templates.
 */
public interface GroupDAOInterface {
    public boolean insert(Groups gr) throws MyException;
    public boolean delete(int userID) throws MyException;
}
