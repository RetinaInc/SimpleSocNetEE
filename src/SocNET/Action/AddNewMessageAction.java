package SocNET.Action;

import SocNET.DAO.MessageDAO;
import SocNET.model.Groups;
import SocNET.model.Message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/9/13
 * Time: 2:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddNewMessageAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MessageDAO mdao = new MessageDAO();
        int idUser =(int) request.getSession().getAttribute("idUser");
        Groups g =(Groups) request.getSession().getAttribute("grouppage");
        int idGroup = g.getIdGroup();
        String title = request.getParameter("title");
        String bodymess = request.getParameter("bodymess");
        //    public Message(String title, String bodymess,String createDate, int idUser, int idGroup)
        Date d = new Date();
        Message mess = new Message(title,bodymess,d.toString(),idUser,idGroup);
        mdao.insert(mess);



        //TODO: think about refreshing message board;

        return "group";
    }
}
