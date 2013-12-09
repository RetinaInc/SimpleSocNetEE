package SocNET.Action;

import SocNET.Additional.MessageViewer;
import SocNET.DAO.MessageDAO;
import SocNET.model.Groups;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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
        String str = request.getParameter("groupName");
        MessageDAO mdao = new MessageDAO();
        MessageViewer mv = new MessageViewer();

        List<MessageViewer> mvlist = new ArrayList<>();
        mvlist = mdao.getAllMessagesByGroupID(g.getIdGroup());
        request.setAttribute("messinfo",mvlist);

        return "group";
    }
}
