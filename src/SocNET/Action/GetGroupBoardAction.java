package SocNET.Action;

import SocNET.DAO.MessageDAO;
import SocNET.model.Groups;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/8/13
 * Time: 10:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class GetGroupBoardAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Groups g = new Groups();
        g =(Groups) request.getAttribute("group");
        MessageDAO mdao = new MessageDAO();

        return "group";
    }
}
