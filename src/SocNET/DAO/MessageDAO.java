package SocNET.DAO;

import SocNET.model.Message;
import SocNET.myexception.MyException;
import SocNET.publicDAO.MessageDAOInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/8/13
 * Time: 2:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class MessageDAO extends AbstractDBConn implements MessageDAOInterface {

    @Override
    public boolean insert(final Message mess) throws MyException {
        return booleanOperation(new AbstractDBConn.WrapperDBOperation<Boolean>() {
            @Override
            public Boolean doMethod(Connection dataBase) throws SQLException, MyException {
                PreparedStatement prep = dataBase.prepareStatement(
                        "INSERT INTO MESSAGE(title,bodymess,create_date,id_user,id_group) values (?,?,?,?,?)"
                );
                prep.setString(1,mess.getTitle());
                prep.setString(2,mess.getBodymess());
                prep.setString(3,mess.getCreate_date());
                prep.setInt(4,mess.getIdUser());
                prep.setInt(5,mess.getIdGroup());

                prep.executeUpdate();
                return true;
            }
        });
    }

    @Override
    public boolean delete(final int userID) throws MyException {
        return booleanOperation(new AbstractDBConn.WrapperDBOperation<Boolean>() {
            @Override
            public Boolean doMethod(Connection dataBase) throws SQLException, MyException {
                PreparedStatement prep = dataBase.prepareStatement(
                        "DELETE FROM MESSAGE WHERE id_user=?"
                );
                prep.setInt(1,userID);
                java.sql.ResultSet res = prep.executeQuery();
                res.next();
                return true;
            }
        });
    }
}
