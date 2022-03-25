public class Post {
    public enum Access {
        PUBLIC,
        FRIENDS_ONLY,
        PRIVATE,
    }

    private String id;
    private String content;
    private Access access;
    private User owner;

    public Post(String id, String content, Access access, User owner) {
        this.id = id;
        this.content = content;
        this.access = access;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
