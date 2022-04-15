import static org.junit.jupiter.api.Assertions.*;

class PasswordPolicyCheckerTest {
    public void oldUser() {
        UserDAO users = new InMemoryUserDAO();
        int id = users.create(new User("foo", "bar"));
        PasswordPolicyChecker checker = new PasswordPolicyChecker(users);
        assert(checker.shouldChangePassword(id) == true);
    }
}