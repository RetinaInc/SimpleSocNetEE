package DAO;

import control.myexception.MyException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/7/13
 * Time: 1:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class AbstractDBConn {
    abstract class WrapperDBOperation<T> {
        abstract public T doMethod(Connection dataBase) throws MyException, SQLException;
    }

    protected <T> T booleanOperation(WrapperDBOperation<T> operation) throws MyException {
        Connection dataBase = null;
        try {
            InitialContext ctx = new InitialContext();
            //DataSource ds = (DataSource) ctx.lookup("jdbc/SocNet");
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            String url = "jdbc:mysql://localhost/SocNet";
            dataBase = DriverManager.getConnection(url, "root", "1111");
            // dataBase = ds.getConnection();
            return operation.doMethod(dataBase);
        } catch (SQLException e) {
            try {
                dataBase.rollback();
                throw new MyException(e.getMessage());
                //return null;
            } catch (SQLException e1) {
                //e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                throw new MyException(e1.getMessage());
            }
        } catch (NamingException e) {
            try {
                dataBase.rollback();
                //return null;
                throw new MyException(e.getMessage());
            } catch (SQLException e1) {
                //e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                throw new MyException(e1.getMessage());
            }
            //e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            try {
                dataBase.close();
            } catch (SQLException e) {
                //e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                //return null;
                throw new MyException(e.getMessage());
            }
        }
    }
}
