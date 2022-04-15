import java.sql.Connection;
import java.util.Date;

public class PasswordPolicyChecker {
    private UserDAO users;

    public PasswordPolicyChecker(UserDAO users) {
        this.users = users;
    }

    public boolean shouldChangePassword(int id) {
        User user = users.getUserById(id);
        Date current = new Date();
        long diff = current.getTime() - user.getLastTimePasswordUpdated().getTime();
        if (diff > 365 * 1231) {
            return true;
        } else {
            return false;
        }
    }
}
