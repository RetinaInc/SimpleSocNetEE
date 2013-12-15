package SocNET.Action;

import SocNET.DAO.GroupDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/14/13
 * Time: 1:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddParticipantToGroupsAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        GroupDAO gdao = new GroupDAO();

        return "mygroups";

    }
}
