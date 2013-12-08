package SocNET.publicDAO;

import SocNET.Additional.MessageViewer;
import SocNET.model.Message;
import SocNET.myexception.MyException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/8/13
 * Time: 2:24 AM
 * To change this template use File | Settings | File Templates.
 */
public interface MessageDAOInterface {
    public boolean insert(Message mess) throws MyException;
    public boolean delete(int userID) throws MyException;
    public List<MessageViewer> getAllMessagesByGroupID(int groupID) throws MyException;

}
