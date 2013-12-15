package SocNET.Additional;

import SocNET.model.Groups;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/15/13
 * Time: 2:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class InfoGroupUser {
    private int idGroup;
    private String groupName;
    private String description;
    private int idCreator;
    private String usernameCreator;
    private int loginUserStatus;//0 - no;1 - member;3-creator;

    public InfoGroupUser(){

    }

    public InfoGroupUser(int idGroup,String groupName,String descrtiption,int idCreator,
                         String usernameCreator,int loginUserStatus){
        this.idGroup =idGroup;
        this.groupName = groupName;
        this.description = descrtiption;
        this.idCreator = idCreator;
        this.usernameCreator = usernameCreator;
        this.loginUserStatus = loginUserStatus;

    }

    public InfoGroupUser(Groups g,String usernameCreator,int loginUserStatus){
        this.idGroup = g.getIdGroup();
        this.groupName = g.getGroupName();
        this.description = g.getDescription();
        this.idCreator = g.getIdUser();
        this.usernameCreator = usernameCreator;
        this.loginUserStatus = loginUserStatus;
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

    public int getIdCreator() {
        return idCreator;
    }

    public void setIdCreator(int idCreator) {
        this.idCreator = idCreator;
    }

    public String getUsernameCreator() {
        return usernameCreator;
    }

    public void setUsernameCreator(String usernameCreator) {
        this.usernameCreator = usernameCreator;
    }

    public int getLoginUserStatus() {
        return loginUserStatus;
    }

    public void setLoginUserStatus(int loginUserStatus) {
        this.loginUserStatus = loginUserStatus;
    }
}
