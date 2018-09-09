package presentation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Item;
import persistent.ItemStorage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class JsonController extends HttpServlet {
    private Gson gson = new GsonBuilder().create();
    private ItemStorage storage = ItemStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        List<Item> saveItems = storage.findAll();
        String jsonDate = gson.toJson(saveItems);
        System.out.println(jsonDate);
        writer.append(jsonDate);
        writer.flush();
    }
}
