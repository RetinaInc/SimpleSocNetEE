package SocNET.DAO;

import SocNET.model.Groups;
import SocNET.myexception.MyException;
import SocNET.publicDAO.GroupDAOInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/8/13
 * Time: 1:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class GroupDAO extends AbstractDBConn implements GroupDAOInterface {
    @Override
    public boolean insert(final Groups gr) throws MyException {

        return booleanOperation(new AbstractDBConn.WrapperDBOperation<Boolean>() {
            @Override
            public Boolean doMethod(Connection dataBase) throws SQLException, MyException {
                PreparedStatement prep = dataBase.prepareStatement(
                        "INSERT INTO GROUPS (group_name,descrtiption,id_user) values(?,?,?)"
                );
                //NamedParameterStatement p = new NamedParameterStatement(con, query);
                // prep.setInt(1,11);
                prep.setString(1,gr.getGroupName());
                prep.setString(2, gr.getDescription());
                prep.setInt(3, gr.getIdUser());
                //String str = prep.;

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
                            "DELETE FROM GROUPS WHERE id_user=?"
                    );
                    prep.setInt(1,userID);
                    java.sql.ResultSet res = prep.executeQuery();
                    res.next();
                    return true;
                }
            });
        }
}
