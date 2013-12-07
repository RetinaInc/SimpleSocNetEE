package SocNET.model;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/8/13
 * Time: 1:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class Groups {
    private int idGroup;
    private String groupName;
    private String description;
    private int idUser; //creator

    public Groups(){

    }

    public Groups(int idGroup, String groupName, String description, int idUser){
        this.idGroup = idGroup;
        this.groupName = groupName;
        this.description = description;
        this.idUser = idUser;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
