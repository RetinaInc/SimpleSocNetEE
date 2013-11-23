package control;

import control.Action.Action;
import control.Action.ActionFactory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 11/14/13
 * Time: 11:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        String view = null;
        Action action = ActionFactory.getAction(request);
        try {
            view = action.execute(request, response);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        dispatch(request,response,view);

    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException {
        String prefix ="";
        String sufix =".jsp";
        //request.setAttribute("");
        request.getRequestDispatcher(prefix + view + sufix).forward(request, response);
    }
}
