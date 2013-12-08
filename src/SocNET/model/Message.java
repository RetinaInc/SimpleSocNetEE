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
    private String create_date;
    private int idUser;
    private int idGroup;

    public Message(){

    }

    public Message(int idMess,String title,String bodymess,String create_date,int idUser, int idGroup){
        this.idMess = idMess;
        this.title = title;
        this.bodymess = bodymess;
        this.create_date = create_date;
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

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
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
