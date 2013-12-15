package SocNET.Action;

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
        return "mygroups";
    }
}
