package presentation;

import model.Advertisement;
import persistent.CarStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdvConroller extends HttpServlet {
    private CarStorage storage = CarStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("advs", storage.findAll());
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String button = req.getParameter("submit");
        System.out.println(req.getParameter("submit"));
        if ("change".equals(button)) {
            storage.update(Integer.parseInt(req.getParameter("idAdv")));
            doGet(req, resp);
        }
        if ("Enter".equals(button)) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            if (storage.isCredentional(login, password)) {
                HttpSession session = req.getSession();
                session.setAttribute("login", login);
            } else {
                req.setAttribute("error", "Enter invalid");
            }
            doGet(req, resp);
        } else {
            resp.sendRedirect(String.format("%s/add", req.getContextPath()));
        }
    }
}
