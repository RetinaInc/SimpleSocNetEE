package control.Action;

import DAO.UserDAO;
import DAO.UserDao;
import DAO.Users;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    UserDao users;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {


        UserDAO uDAO = new UserDAO();
        boolean bool;
        User user;
        try {
            //String lastname, String firstname, String email, String password
            user = new User(request.getParameter("lastname"),request.getParameter("firstname"),
                            request.getParameter("email"),request.getParameter("password"));
            bool = uDAO.insert(user);
           // Users user_stored = users.getUserObj(user.getEmail(),user.getPswd());
          //  ConfirmationEmailDAO ConEmail =(ConfirmationEmailDAO) ctx.getBean("conemailDAO");

            //get hash

            //send mail

        } catch (Exception ex) {
            request.setAttribute("error_message",ex.getMessage());
            return "exception";
        }

        return "index";
    }

}
