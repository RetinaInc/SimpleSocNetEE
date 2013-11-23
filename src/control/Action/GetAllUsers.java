package control.Action;

import DAO.UserDAO;

import model.User;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 11/6/13
 * Time: 1:42 PM
 */
public class GetAllUsers implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserDAO uDAO = new UserDAO();
        List<User> users = uDAO.getAllUsers();
        request.setAttribute("allusers",users);

        return "showalluser";
    }
}
