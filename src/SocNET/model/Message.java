package SocNET.model;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/8/13
 * Time: 2:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class Message {
    private int idMess;
    private String title;
    private String bodymess;
    private String createDate;
    private int idUser;
    private int idGroup;

    public Message(){

    }

    public Message(String title, String bodymess,String createDate, int idUser, int idGroup){
        this.title = title;
        this.bodymess = bodymess;
        this.createDate = createDate;
        this.idUser = idUser;
        this.idGroup = idGroup;

    }

    public Message(int idMess,String title,String bodymess,String createDate,int idUser, int idGroup){
        this.idMess = idMess;
        this.title = title;
        this.bodymess = bodymess;
        this.createDate = createDate;
        this.idUser = idUser;
        this.idGroup = idGroup;
    }

    public int getIdMess() {
        return idMess;
    }

    public void setIdMess(int idMess) {
        this.idMess = idMess;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBodymess() {
        return bodymess;
    }

    public void setBodymess(String bodymess) {
        this.bodymess = bodymess;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }
}
