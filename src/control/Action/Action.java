package control.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 11/14/13
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
