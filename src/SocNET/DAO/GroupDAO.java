package SocNET.DAO;

import SocNET.model.Groups;
import SocNET.myexception.MyException;
import SocNET.publicDAO.GroupDAOInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean addParticipant(final int userID,final  int groupID) throws MyException {
        return booleanOperation(new AbstractDBConn.WrapperDBOperation<Boolean>() {
            @Override
            public Boolean doMethod(Connection dataBase) throws SQLException, MyException {
                PreparedStatement prep = dataBase.prepareStatement(
                        "INSERT INTO GROUPS_PARTICIPANT (id_user, id_group) values(?,?)"
                );
                prep.setInt(1,userID);
                prep.setInt(2,groupID);
                //String str = prep.;

                prep.executeUpdate();
                return true;
            }
        });
    }

    @Override
    public List<Groups> getAllGroups() throws MyException {
        return booleanOperation(new WrapperDBOperation<List<Groups>>() {

            @Override
            public List<Groups> doMethod(Connection dataBase) throws MyException, SQLException {
                PreparedStatement prep = dataBase.prepareStatement(
                        "SELECT * FROM GROUPS"
                );

                java.sql.ResultSet res = prep.executeQuery();
                List<Groups> glist = new ArrayList<Groups>();
                while(res.next()){
                    int id = res.getInt(1);
                    String name = res.getString(2);
                    String desc = res.getString(3);
                    int idOwner = res.getInt(4);
                    glist.add(new Groups(id,name,desc,idOwner));
                }

                return glist;

            }
        });
    }

    @Override
    public List<Groups> getMyGroups(final int userID) throws MyException {
        return booleanOperation(new WrapperDBOperation<List<Groups>>() {

            @Override
            public List<Groups> doMethod(Connection dataBase) throws MyException, SQLException {
                PreparedStatement prep = dataBase.prepareStatement(
                        "SELECT * FROM GROUPS WHERE GROUPS.id_user=?"
                );
                prep.setInt(1,userID);
                java.sql.ResultSet res = prep.executeQuery();
                List<Groups> glist = new ArrayList<Groups>();
                while(res.next()){
                    int id = res.getInt(1);
                    String name = res.getString(2);
                    String desc = res.getString(3);
                    int idOwner = res.getInt(4);
                    glist.add(new Groups(id,name,desc,idOwner));
                }

                return glist;

            }
        });
    }

    @Override
    public List<Groups> getMySubsGroups(final int userID) throws MyException {
        return booleanOperation(new WrapperDBOperation<List<Groups>>() {

            @Override
            public List<Groups> doMethod(Connection dataBase) throws MyException, SQLException {
                PreparedStatement prep = dataBase.prepareStatement(
                        "SELECT GROUPS.id_group,GROUPS.group_name,GROUPS.descrtiption,GROUPS.id_user " +
                                " FROM GROUPS, GROUP_PARTICIPANT WHERE GROUP_PARTICIPANT.id_user=? " +
                                " AND GROUPS.id_group=GROUP_PARTICIPANT.id_group;"
                );
                prep.setInt(1,userID);
                java.sql.ResultSet res = prep.executeQuery();
                List<Groups> glist = new ArrayList<Groups>();
                while(res.next()){
                    int id = res.getInt(1);
                    String name = res.getString(2);
                    String desc = res.getString(3);
                    int idOwner = res.getInt(4);
                    glist.add(new Groups(id,name,desc,idOwner));
                }

                return glist;

            }
        });
    }
}
