// Data Access Object
// CRUD - Create Read Update Delete
public interface UserDAO {
    User getUserById(int id);
//    User getUserByUsername(String username);
    int create(User user);
//    void delete(User user);
//    void delete(int id);
//    void update(User user);
//    void update(int id, String password);
}
