package music.presentation;

import music.persistent.DBUsers;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginTest {

    String path = "/WEB-INF/views/login.jsp";

    @Test
    public void whenUserLoginThenSignInUsersThatYetCreate() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher(path)).thenReturn(dispatcher);
        when(request.getParameter("user")).thenReturn("petr");
        when(request.getParameter("submit")).thenReturn("registration");
        when(request.getParameter("password")).thenReturn("123");
        assertThat((new DBUsers()).isCredentional(request.getParameter("user"), request.getParameter("password")), is(true));
    }
}