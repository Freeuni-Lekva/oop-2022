public class SQLBasedStorage implements Storage {
    @Override
    public void addPost(Post post) {
        // db.Execute("INSERT INTO Posts")
    }

    @Override
    public Post getPost(String id, User current) {
        return null;
    }
}
