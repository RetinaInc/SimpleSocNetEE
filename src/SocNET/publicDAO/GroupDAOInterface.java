package SocNET.publicDAO;

import SocNET.model.Groups;
import SocNET.model.User;
import SocNET.myexception.MyException;

import java.util.List;

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
    public List<Groups> getAllGroups() throws  MyException;
    public List<Groups> getMyGroups(int userID) throws MyException; //user is creator
    public List<Groups> getMySubsGroups(int userID) throws MyException;  //user is member

    //for group_participant

    public boolean addParticipant(int userID,int groupID) throws MyException;



}
