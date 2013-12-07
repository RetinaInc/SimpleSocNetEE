package SocNET.Action;

import SocNET.DAO.UserDAO;
import SocNET.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 11/14/13
 * Time: 11:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class SignUpAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {


        UserDAO uDAO = new UserDAO();
        boolean bool;
        User user;
        try {
            //String lastname, String firstname, String email, String password
            user = new User(request.getParameter("login"),
                            request.getParameter("email"),request.getParameter("password"));
            bool = uDAO.insert(user);


        } catch (Exception ex) {
            request.setAttribute("error_message",ex.getMessage());
            return "exception";
        }

        return "index";
    }

}
