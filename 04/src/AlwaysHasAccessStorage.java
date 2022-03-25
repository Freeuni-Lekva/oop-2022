import java.util.HashMap;
import java.util.Map;

public class AlwaysHasAccessStorage implements Storage {
    Map<String, Post> posts;

    public AlwaysHasAccessStorage() {
        posts = new HashMap<>();
    }

    @Override
    public void addPost(Post post) {
        posts.put(post.getId(), post);
    }

    @Override
    public Post getPost(String id, User current) {
        return posts.get(id);
    }
}
