import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDAO implements UserDAO {
    private Map<Integer, User> users;
    private int counter;

    public InMemoryUserDAO() {
        users = new HashMap<>();
        counter = 0;
    }

    @Override
    public User getUserById(int id) {
        return users.get(id);
    }

    @Override
    public int create(User user) {
        user.setId(counter);
        users.put(counter, user);
        counter++;
        return user.getId();
    }
}
