package zuryanov.servlets.presentation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import zuryanov.servlets.persistent.MemoryStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class JsonController extends HttpServlet {

    private Gson gson = new GsonBuilder().create();
    List<String> names = MemoryStore.getInstance().findAll();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        List<User> saveUsers = new LinkedList<>();

        System.out.println(names.size());

        for (int i = 0; i < names.size(); i++) {
            User user = new User();
            user.setLogin(names.get(i));
            saveUsers.add(user);
        }

        String jsonData = gson.toJson(saveUsers);
        System.out.println(jsonData);
        writer.append(jsonData);
        writer.flush();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        names.add(req.getParameter("login"));

    }
}
