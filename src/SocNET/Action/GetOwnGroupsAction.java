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
 * Date: 12/14/13
 * Time: 1:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class GetOwnGroupsAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getSession().getAttribute("userfull")==null){
            return "index";
        }

        GroupDAO gdao = new GroupDAO();

        List<Groups> glist;
        int userID =(Integer) request.getSession().getAttribute("id_user");
        glist = gdao.getMyGroups(userID);
        request.setAttribute("allmygroups",glist);


        return "mygroups";
    }
}
