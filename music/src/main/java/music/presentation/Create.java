package music.presentation;

import music.model.Address;
import music.model.MusicType;
import music.model.User;
import music.persistent.DBAddress;
import music.persistent.DBMusicType;
import music.persistent.DBUsers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Create extends HttpServlet {
    private DBUsers usr = new DBUsers();
    private DBAddress addrss = new DBAddress();
    private DBMusicType type = new DBMusicType();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Set<String> countries = new HashSet<>();
        Set<String> cities = new HashSet<>();
        Set<String> types = new HashSet<>();
        for (Address address : addrss.findAll()) {
            countries.add(address.getCountry());
            cities.add(address.getCity());
        }
        session.setAttribute("countries", countries);
        session.setAttribute("cities", cities);
        for (MusicType musicType : type.findAll()) {
            types.add(musicType.getName());
        }
        session.setAttribute("musictypes", types);
        req.getRequestDispatcher("/WEB-INF/views/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        for (User user : usr.findAll()) {
            if (user.getName().equals(login)) {
                req.setAttribute("error", "This login is already taken");
                doGet(req, resp);
            }
        }
        HttpSession session = req.getSession();
        User user = new User();
        Address address = new Address();
        session.setAttribute("login", login);
        user.setName(login);
        user.setPassword(req.getParameter("password"));
        String country = req.getParameter("state");
        String city = req.getParameter("city");
        address.setCountry(country);
        address.setCity(city);
        addrss.add(address);
        user.setAddressId(addrss.findByParam(country, city));
        user.setFirstName(req.getParameter("frstname"));
        user.setLastName(req.getParameter("lstname"));
        user.setAge(Integer.parseInt(req.getParameter("age")));
        user.setMusicTypeId(type.findByName(req.getParameter("genrename")));
        user.setRoleId(1);
        usr.add(user);
        resp.sendRedirect(String.format("%s/user", req.getContextPath()));
    }
}
