package SocNET.Action;

import SocNET.DAO.UserDAO;
import SocNET.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/7/13
 * Time: 11:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginUserAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserDAO udao = new UserDAO();
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        //TODO: other validation and exception
        if(!udao.getUser(email,pass)){
            request.setAttribute("wrongPass",true);
            return "login";
        }

        User user;
        user = udao.getUserObj(email,pass);
        if (user != null ){
            request.getSession().setAttribute("id_user",user.getId_user());
            request.getSession().setAttribute("email",user.getEmail());
            request.getSession().setAttribute("username",user.getUsername());
            request.getSession().setAttribute("userfull",user);
        }

        return "index";
    }
}
