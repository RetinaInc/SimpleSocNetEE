package SocNET.DAO;

import SocNET.Additional.MessageViewer;
import SocNET.model.Message;
import SocNET.myexception.MyException;
import SocNET.publicDAO.MessageDAOInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                prep.setString(3,mess.getCreateDate());
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

    @Override
    public List<MessageViewer> getAllMessagesByGroupID(final int groupID) throws MyException {
        return booleanOperation(new WrapperDBOperation<List<MessageViewer>>() {

            @Override
            public List<MessageViewer> doMethod(Connection dataBase) throws MyException, SQLException {
                PreparedStatement prep = dataBase.prepareStatement(
                        "SELECT MESSAGE.id_mess,MESSAGE.title,MESSAGE.bodymess,MESSAGE.create_date,MESSAGE.id_user, " +
                                "       MESSAGE.id_group, USERS.username,USERS.email,USERS.password " +
                                "  FROM MESSAGE ,USERS " +
                                "  WHERE MESSAGE.id_group=? AND MESSAGE.id_user=USERS.id_user"
                );
                prep.setInt(1,groupID);
                java.sql.ResultSet res = prep.executeQuery();
                List<MessageViewer> glist = new ArrayList<MessageViewer>();
                while(res.next()){
                    int idMess = res.getInt(1);
                    String title = res.getString(2);
                    String bodymess = res.getString(3);
                    String createDate = res.getString(4);
                    int idUser = res.getInt(5);
                    int idGroup = res.getInt(6);
                    String username = res.getString(7);
                    String email = res.getString(8);
                    String pass = res.getString(9);
                    glist.add(new MessageViewer(idMess,title,bodymess,createDate,idUser,idGroup,username,email,pass));

                }

                return glist;

            }
        });
    }
}
