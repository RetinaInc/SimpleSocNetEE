package SocNET.Action;

import SocNET.DAO.GroupDAO;
import SocNET.logic.Facade;
import SocNET.model.Groups;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/14/13
 * Time: 12:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class GetAllSubscribedGroupsAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        if(request.getSession().getAttribute("userfull")==null){
            return "index";
        }

        GroupDAO gdao = new GroupDAO();

        List<Groups> glist = new ArrayList<Groups>();
        int userID =(int) request.getSession().getAttribute("user_id");
        glist = gdao.getMySubsGroups(userID);
        request.setAttribute("allsubgroups",glist);


        return "mygroups";

    }
}
