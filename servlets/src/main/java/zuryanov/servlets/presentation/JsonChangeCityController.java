package zuryanov.servlets.presentation;

import zuryanov.servlets.logic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonChangeCityController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        ValidateService.getInstance().update(ValidateService.getInstance().findByName(req.getParameter("name")),
                req.getParameter("name"), req.getParameter("countryname"), req.getParameter("cityname"));
    }
}
