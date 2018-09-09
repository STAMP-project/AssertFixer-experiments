package music.presentation;

import music.persistent.DBUsers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends HttpServlet {
    private DBUsers logic = new DBUsers();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if ("registration".equals(req.getParameter("submit"))) {
            resp.sendRedirect(String.format("%s/create", req.getContextPath()));
        } else {
            if (logic.isCredentional(login, password)) {
                int role = logic.findByLogin(login).getRoleId();
                HttpSession session = req.getSession();
                synchronized (session) {
                    session.setAttribute("login", login);
                    session.setAttribute("rolesession", role);
                }
                switch (role) {
                    case 1:
                        resp.sendRedirect(String.format("%s/admin", req.getContextPath()));
                        break;
                    case 2:
                        resp.sendRedirect(String.format("%s/moder", req.getContextPath()));
                        break;
                    case 3:
                        resp.sendRedirect(String.format("%s/user", req.getContextPath()));
                        break;
                    default:
                        resp.sendRedirect(String.format("%s/login", req.getContextPath()));
                        break;
                }
            } else {
                req.setAttribute("error", "Credentional invalid");
                doGet(req, resp);
            }
        }
    }
}
