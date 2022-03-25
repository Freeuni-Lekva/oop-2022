public class AlwaysNullStorage implements Storage {
    @Override
    public void addPost(Post post) {

    }

    @Override
    public Post getPost(String id, User current) {
        return null;
    }
}
