package model;

/**
 * Created with IntelliJ IDEA.
 * User: pasha
 * Date: 11/23/13
 * Time: 10:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private int id_user;
    private String lastname;
    private String firstname;
    private String email;
    private String password;

    public User(){

    }

    public User(String lastname, String firstname, String email, String password){
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
    }

    public User(int id_user,String lastname, String firstname, String email, String password){
        this.id_user = id_user;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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
