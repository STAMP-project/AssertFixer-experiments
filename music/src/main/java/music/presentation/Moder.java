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
import java.util.ArrayList;
import java.util.List;

public class Moder extends HttpServlet {
    private DBUsers usr = new DBUsers();
    private DBRole role = new DBRole();
    private DBAddress address = new DBAddress();
    private DBMusicType music = new DBMusicType();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<User> userList = new ArrayList<>();
        List<Role> roleList = new ArrayList<>();
        List<Address> addressList = new ArrayList<>();
        List<MusicType> musicList = new ArrayList<>();
        for (User user : usr.findAll()) {
            userList.add(user);
            roleList.add(role.getById(user.getRoleId()));
            addressList.add(address.getById(user.getAddressId()));
            musicList.add(music.getById(user.getMusicTypeId()));
        }
        session.setAttribute("users", userList);
        session.setAttribute("roles", roleList);
        session.setAttribute("addresses", addressList);
        session.setAttribute("genres", musicList);
        req.getRequestDispatcher("/WEB-INF/views/moder.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
