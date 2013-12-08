package SocNET.Action;

import SocNET.DAO.GroupDAO;
import SocNET.model.Groups;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/8/13
 * Time: 9:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class GetAllGroupsAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        GroupDAO gdao = new GroupDAO();
        List<Groups> glist = new ArrayList<Groups>();

        glist = gdao.getAllGroups();
        request.setAttribute("allgroups",glist);


        return "mygroups";
    }
}
