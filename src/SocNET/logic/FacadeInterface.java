package SocNET.logic;

import SocNET.Additional.MessageViewer;
import SocNET.model.Groups;
import SocNET.myexception.MyException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/13/13
 * Time: 11:29 PM
 * To change this template use File | Settings | File Templates.
 */
public interface FacadeInterface {

    //message logic
    void insertMessage(int idGroup,int idUser,String title,String bodymess) throws MyException;
    List<MessageViewer> getMessListByGroupID(int groupID) throws MyException;

    //group logic
    List<Groups> getAllGroups() throws MyException;
    List<Groups> getAllSubGroups(int userID) throws MyException;
}
