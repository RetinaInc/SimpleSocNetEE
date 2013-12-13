package SocNET.logic;

import SocNET.Additional.MessageViewer;
import SocNET.DAO.GroupDAO;
import SocNET.DAO.MessageDAO;
import SocNET.DAO.UserDAO;
import SocNET.model.Groups;
import SocNET.model.Message;
import SocNET.myexception.MyException;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/13/13
 * Time: 11:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Facade implements FacadeInterface {
    private GroupDAO groupdao;
    private MessageDAO messagedao;
    private UserDAO userdao;

    @Override
    public void insertMessage(int idGroup, int idUser, String title, String bodymess) throws MyException {
        MessageDAO mdao = new MessageDAO();

        Date d = new Date();
        Message mess = new Message(title,bodymess,d.toString(),idUser,idGroup);
        messagedao.insert(mess);
    }

    @Override
    public List<MessageViewer> getMessListByGroupID(int groupID) throws MyException {
        return messagedao.getAllMessagesByGroupID(groupID);
    }

    @Override
    public List<Groups> getAllGroups() throws MyException {
        groupdao = new GroupDAO();
        return groupdao.getAllGroups();
    }

    @Override
    public List<Groups> getAllSubGroups(int userID) throws MyException {
        groupdao = new GroupDAO();
        return groupdao.getMySubsGroups(userID);
    }
}
