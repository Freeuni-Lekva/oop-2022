import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private Date lastTimePasswordUpdated;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastTimePasswordUpdated() {
        return lastTimePasswordUpdated;
    }

    public void setLastTimePasswordUpdated(Date lastTimePasswordUpdated) {
        this.lastTimePasswordUpdated = lastTimePasswordUpdated;
    }
}
