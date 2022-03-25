public interface Storage {
    public void addPost(Post post);
    public Post getPost(String id, User current);
}
