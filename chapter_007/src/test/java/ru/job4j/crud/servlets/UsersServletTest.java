package ru.job4j.crud.servlets;

import org.junit.Test;
import ru.job4j.crud.store.DbStore;
import ru.job4j.crud.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Yury Matskevich
 */
public class UsersServletTest {

	@Test
	public void deleteUserWithCurrentIdTest() throws ServletException, IOException {
		Store store = DbStore.getInstance();
		UsersServlet usersServlet = new UsersServlet();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		String id = Integer.toString(store.findAll().get(0).getId()); // there is a user with such id
		when(request.getParameter("id")).thenReturn(id);
		usersServlet.doPost(request, response);
		assertTrue(store.findAll().isEmpty());
	}
}
