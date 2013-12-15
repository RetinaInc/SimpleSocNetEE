package SocNET.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/15/13
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class SignoutAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // If User is unauthorized then ge can't sign out
        if(request.getSession().getAttribute("email") == null){
            return "home";
        }
        request.getSession().invalidate();
        return "home";
    }
}
