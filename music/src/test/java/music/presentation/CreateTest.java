package music.presentation;

import music.model.User;
import music.persistent.DBUsers;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreateTest {

    String path = "/WEB-INF/views/create.jsp";

    @Test
    public void whenUserCreateThenDontCreateDouble() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher(path)).thenReturn(dispatcher);
        when(request.getParameter("login")).thenReturn("petr");

        DBUsers usr = new DBUsers();
        boolean flag = false;
        for (User user : usr.findAll()) {
            if (user.getName().equals(request.getParameter("login"))) {
                flag = true;
            }
        }
        assertThat(flag, is(true));
    }
}