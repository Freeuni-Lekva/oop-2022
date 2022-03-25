import java.nio.file.AccessDeniedException;

public class UI {
    private Storage storage;

    public UI(Storage storage) {
        this.storage = storage;
    }

    public String renderPost(String id, User current) throws AccessDeniedException {
        Post post = storage.getPost(id, current);
        if (post == null) {
            throw new AccessDeniedException("no read permissions");
        } else {
            return post.getContent();
        }
    }
}
