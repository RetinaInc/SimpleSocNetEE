package SocNET.Action;

import SocNET.DAO.GroupDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/14/13
 * Time: 1:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class DelParticipantFromGroupsActions implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        GroupDAO gdao = new GroupDAO();
        String gID = request.getParameter("grp");
        int groupID = Integer.parseInt(gID);
        int userID =(int) request.getSession().getAttribute("id_user");
        gdao.delParicipant(userID,groupID);
        return "mygroups";
    }
}
