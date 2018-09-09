package music.presentation;

import music.model.User;
import music.persistent.DBUsers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class EditTest {
    String path = "/WEB-INF/views/edit.jsp";

    @Test
    public void whenUserUpdateThenChangeId() {
        User user = new User();
        user.setName("ivan");
        user.setPassword("123");
        user.setFirstName("ivan");
        user.setLastName("petrov");
        user.setAge(20);
        user.setRoleId(2);
        user.setAddressId(2);
        user.setMusicTypeId(1);
        user.setId(6);
        new DBUsers().update(user);
        assertThat(new DBUsers().findByLogin("ivan").getId(), is(6));
    }
}