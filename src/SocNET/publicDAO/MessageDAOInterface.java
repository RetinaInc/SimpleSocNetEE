package SocNET.publicDAO;

import SocNET.model.Message;
import SocNET.myexception.MyException;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/8/13
 * Time: 2:24 AM
 * To change this template use File | Settings | File Templates.
 */
public interface MessageDAOInterface {
    public boolean insert(Message mess) throws MyException;
    public boolean delete(final int userID) throws MyException;
}
