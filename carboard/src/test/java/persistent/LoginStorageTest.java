package persistent;

import model.Engine;
import model.Login;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LoginStorageTest {
    private final LoginStorage loginStorage = LoginStorage.getInstance();

    @Test
    public void testFind() {
        Login login = new Login();
        login.setName("admin");
        login.setPassword("123");
        login = this.loginStorage.add(login);
        assertThat(login, is(this.loginStorage.find(login.getName())));
    }
}
