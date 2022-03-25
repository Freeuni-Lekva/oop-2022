import java.util.Date;

public class Tweet {
    private User user;
    private Date createdAt;
    private String contents;

    public Tweet(User user, Date createdAt, String contents) {
//        this.user = clone(user);
//        this.createdAt = clone(createdAt);
//        this.contents = clone(contents);
    }

    public User getUser() {
        return user;
    }

    public Date getCreatedAt() {
        Date d = new Date();
        d.setTime(createdAt.getTime());
        return d;
    }

    public String getContents() {
        return contents;
    }
}
