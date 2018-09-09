package presentation;

import persistent.CarStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddController extends HttpServlet {
    private CarStorage storage = CarStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("carbodyitems", storage.findCarBody());
        req.setAttribute("transmissionitems", storage.findTransmission());
        req.setAttribute("engineitems", storage.findEngine());
        req.setAttribute("branditems", storage.findBrand());
        req.getRequestDispatcher("/WEB-INF/views/new.jsp").forward(req, resp);
    }
}
