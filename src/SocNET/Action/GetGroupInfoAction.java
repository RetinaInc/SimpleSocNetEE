package SocNET.Action;

import SocNET.Additional.InfoGroupUser;
import SocNET.DAO.GroupDAO;
import SocNET.DAO.UserDAO;
import SocNET.model.Groups;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/15/13
 * Time: 2:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class GetGroupInfoAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getSession().getAttribute("userfull")==null){
            return "index";
        }

        GroupDAO gdao = new GroupDAO();
        UserDAO udao = new UserDAO();
        List<Groups> glist = new ArrayList<Groups>();

        glist = gdao.getAllGroups();
        List<InfoGroupUser> ginfolist= new ArrayList<>();
        int status =0;
        String creatorName;
        int loginUserID = (int) request.getSession().getAttribute("id_user");
        for(Groups g: glist){
            creatorName= udao.getUsernameByID(g.getIdUser());
            if(g.getIdUser()==loginUserID){
                status=2;
            }
            else{
                if(gdao.isUserMemberOfGroup(loginUserID,g.getIdGroup())){
                    status = 1;
                }
            }

            ginfolist.add(new InfoGroupUser(g,creatorName,status));


        }
        request.setAttribute("allinfogroups",ginfolist);


        return "mygroups";
    }
}
