package SocNET.Additional;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 12/9/13
 * Time: 12:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class MessageViewer {
    private int id_mess;
    private String title;
    private String bodymess;
    private String create_date;
    private int id_group;
    private int id_user;
    private String username;
    private String email;
    private String password;

    public MessageViewer(){

    }
    public MessageViewer(int id_mess,String title,String bodymess,String create_date,
                         int id_group,int id_user,String username,String email,String password){
        this.id_mess = id_mess;
        this.title = title;
        this.bodymess = bodymess;
        this.create_date = create_date;
        this.id_group = id_group;
        this.id_user = id_user;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getId_mess() {
        return id_mess;
    }

    public void setId_mess(int id_mess) {
        this.id_mess = id_mess;
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

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
