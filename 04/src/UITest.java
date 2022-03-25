import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.nio.file.AccessDeniedException;

import static org.junit.jupiter.api.Assertions.*;

class UITest {
    @Test
    public void checkAccessDeniedLogic() {
        Storage storage = new AlwaysNullStorage();
        UI ui = new UI(storage);
        Assertions.assertThrows(AccessDeniedException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ui.renderPost("1", new User());
            }
        });
    }

    @Test
    public void checkAccessDeniedLogicUsingMockito() {
        Storage storage = Mockito.mock(Storage.class);
        when(storage.getPost(anyString(), new User())).thenReturn(new Post());
        when(storage.getPost(anyString(), anyObject())).thenReturn(null);

        UI ui = new UI(storage);
        Assertions.assertThrows(AccessDeniedException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ui.renderPost("1", new User());
            }
        });
    }

    @Test
    public void checkPostRendersSuccessfully() throws AccessDeniedException {
        Storage storage = new AlwaysHasAccessStorage();
        storage.addPost(new Post("1", "foo", Post.Access.PUBLIC, null));
        UI ui = new UI(storage);
        Assertions.assertEquals("foo", ui.renderPost("1", null));
    }
}