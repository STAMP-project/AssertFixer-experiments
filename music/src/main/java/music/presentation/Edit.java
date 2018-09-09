package music.presentation;

import music.model.Address;
import music.model.MusicType;
import music.model.Role;
import music.model.User;
import music.persistent.DBAddress;
import music.persistent.DBMusicType;
import music.persistent.DBRole;
import music.persistent.DBUsers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Edit extends HttpServlet {
    private DBUsers usr = new DBUsers();
    private DBRole role = new DBRole();
    private DBAddress address = new DBAddress();
    private DBMusicType music = new DBMusicType();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("id", req.getParameter("id"));
        User user = new User();
        user = usr.getById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("name", user.getName());
        req.setAttribute("password", user.getPassword());
        req.setAttribute("frst_name", user.getFirstName());
        req.setAttribute("lst_name", user.getLastName());
        req.setAttribute("age", user.getAge());

        HttpSession session = req.getSession();
        Set<String> roleList = new HashSet<>();
        Set<String> countryList = new HashSet<>();
        Set<String> cityList = new LinkedHashSet<>();
        Set<String> musicList = new HashSet<>();
        for (MusicType musicTypes : music.findAll()) {
            musicList.add(musicTypes.getName());
        }
        for (Address addresses : address.findAll()) {
            countryList.add(addresses.getCountry());
            cityList.add(addresses.getCity());
        }
        for (Role roles : role.findAll()) {
            roleList.add(roles.getName());
        }
        session.setAttribute("cities", cityList);
        session.setAttribute("countries", countryList);
        session.setAttribute("musictypes", musicList);
        session.setAttribute("roles", roleList);
        session.setAttribute("genreattr", music.getById(user.getMusicTypeId()).getName());
        session.setAttribute("roleattr", role.getById(user.getRoleId()).getName());
        req.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        HttpSession session = req.getSession();
        User user = new User();
        user.setId(Integer.parseInt(req.getParameter("id")));
        Address addressNew = new Address();
        session.setAttribute("login", login);
        user.setName(login);
        user.setPassword(req.getParameter("password"));
        String country = req.getParameter("state");
        String city = req.getParameter("city");
        addressNew.setCountry(country);
        addressNew.setCity(city);
        address.add(addressNew);
        user.setAddressId(address.findByParam(country, city));
        user.setFirstName(req.getParameter("frstname"));
        user.setLastName(req.getParameter("lstname"));
        user.setAge(Integer.parseInt(req.getParameter("age")));
        user.setMusicTypeId(music.findByName(req.getParameter("genrename")));
        user.setRoleId(role.findByName(req.getParameter("rolename")));
        usr.update(user);
        resp.sendRedirect(String.format("%s/admin", req.getContextPath()));
    }
}
