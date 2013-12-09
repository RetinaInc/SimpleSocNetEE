package SocNET.Action;

import SocNET.DAO.MessageDAO;
import SocNET.model.Message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        Message m = new Message();

        return "group";
    }
}
