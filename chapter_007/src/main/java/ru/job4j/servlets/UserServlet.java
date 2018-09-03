package ru.job4j.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.User;
import ru.job4j.ValidateService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(UserServlet.class);
    private ValidateService logic;

    public UserServlet() {
        logic = ValidateService.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        StringBuilder sb = new StringBuilder();
        for (User user : logic.findAll()) {
            sb.append("\t\t<tr>\n"
                    + "\t\t<td>" + user.getId().toString() + "</td>\n"
                    + "\t\t<td>" + user.getLogin() + "</td>\n"
                    + "\t\t<td>" + user.getPassword() + "</td>\n"
                    + "\t\t<td>" + user.getName() + "</td>\n"
                    + "\t\t<td>" + user.getEmail() + "</th>\n"
                    + "\t\t<td class=\"noRightBorder\" >\n"
                    + "\t\t\t<form action=\"" + request.getContextPath() + "/update\" method=\"get\">\n"
                    + "<input type=\"hidden\" name=\"id\" value=\"" + user.getId().toString() + "\">"
                    + "<input type=\"hidden\" name=\"login\" value=\"" + user.getLogin() + "\">"
                    + "<input type=\"hidden\" name=\"password\" value=\"" + user.getPassword() + "\">"
                    + "<input type=\"hidden\" name=\"name\" value=\"" + user.getName() + "\">"
                    + "<input type=\"hidden\" name=\"email\" value=\"" + user.getEmail() + "\">"
                    + "        \t\t <input id=\"updateForm\" class=\"button\"  type=\"submit\" name=\"update\" value=\"Update\" />\n"
                    + "    \t\t</form>\n"
                    + "\t\t</td>\n"
                    + "\t\t<td class=\"noLeftBorder\">\n"
                    + "    \t\t<form action=\"/user\" method=\"post\">\n"
                    + "         \t\t<input id=\"deletePost\" class=\"button\" type=\"submit\" name=\"delete\" value=\"Delete\" />\n"
                    + "    \t\t</form>\n"
                    + "\t\t</td>\n"
                    + "\t</tr>\n");
        }
        writer.append("<!DOCTYPE html>\n"
                + "<html>\n"
                + " <head>\n"
                + "   <title>Users</title>\n"
                + "   <meta charset=\"utf-8\">\n"
                + " </head>\n"
                + " <body>\n"
                + " \t<style type=\"text/css\">\n"
                + " \th1 \t{\n"
                + " \t\tfont-family:Arial, sans-serif;\n"
                + " \t\tfont-size:18px; padding:10px 10px;\n"
                + " \t\tfont-weight:lighter;\n"
                + " \t\ttext-align: center;\n"
                + " \t\t}\n"
                + " \t.tableSpace{\n"
                + " \t\tmax-width:  529px;\n"
                + " \t}\n"
                + "  table {\n"
                + "  \tborder-collapse:collapse; \n"
                + "  \tborder-spacing:0;\n"
                + "  }\n"
                + " td{\n"
                + " \tfont-family:Arial, sans-serif;\n"
                + " \tfont-size:14px;padding:8px 8px;\n"
                + " \tborder-style:solid;\n"
                + " \tborder-width:1px;overflow:hidden;\n"
                + " \tword-break:normal\n"
                + " \t;border-color:black;\n"
                + " }\n"
                + " th{\n"
                + " \t\tbackground-color:#c2d1da;\n"
                + "\t \tfont-family:Arial, sans-serif;\n"
                + "\t \tfont-size:14px;\n"
                + "\t \tfont-weight:normal;\n"
                + "\t \tpadding:10px 8px;\n"
                + "\t \tborder-style:solid;\n"
                + "\t \tborder-width:1px;\n"
                + "\t \toverflow:hidden;\n"
                + "\t \tword-break:normal;\n"
                + "\t \tborder-color:black;\n"
                + " }\n"
                + " tr:nth-child(even){\n"
                + " \tbackground-color: #f2f2f2;\n"
                + " \t}\n"
                + "\t.button {\n"
                + "\t\tbackground-color:#d8d8d8;\n"
                + "\t\tborder: none;\n"
                + "\t\tcolor: black;\n"
                + "\t\tpadding: 5px 5px;\n"
                + "\t\ttext-align: center;\n"
                + "\t\ttext-decoration: none;\n"
                + "\t\tdisplay: inline-block;\n"
                + "\t\tfont-size: 14px;\n"
                + " \t\t}\n"
                + "\t.button:hover {\n"
                + "\t\tbackground-color:#b2b2b2;\n"
                + "\t\tborder: none;\n"
                + "\t\tcolor: black;\n"
                + "\t\tpadding: 5px 5px;\n"
                + "\t\ttext-align: center;\n"
                + "\t\ttext-decoration: none;\n"
                + "\t\tdisplay: inline-block;\n"
                + "\t\tfont-size: 14px;\n"
                + " \t\t}\n"
                + "  .noLeftBorder{\n"
                + "  \tborder-left: 0;\n"
                + "  }\n"
                + "  .noRightBorder{ \n"
                + "  \tborder-right: 0;\n"
                + "  }\n"
                + "\n"
                + "</style>\n"
                + "<div class=\"tableSpace\">\n"
                + " <h1>Users table</h1>\n"
                + " <table>\n"
                + "\t<tr >\n"
                + "\t\t<th>Id</th>\n"
                + "\t\t<th>Login</th>\n"
                + "\t\t<th>Password</th>\n"
                + "\t\t<th>Name</th>\n"
                + "\t\t<th>Email</th>\n"
                + "\t\t<th colspan=\"2\"</>Action</th>\n"
                + "\t</tr>\n"
                + sb.toString()
                + "<tr>\n"
                + "\t\t<td></td>\n"
                + "\t\t<td></td>\n"
                + "\t\t<td></td>\n"
                + "\t\t<td></td>\n"
                + "\t\t<td></td>\n"
                + "\t\t<td colspan=\"2\">\n"
                + "\t\t<form action=\"" + request.getContextPath() + "/create\" method=\"get\">"
                + "        <input id=\"saveForm\" class=\"button\" type=\"submit\" name=\"submit\" value=\"Create\" />\n"
                + "\t\t</td>\n"
                + "</tr>\n"
                + " \t</table>\n"
                + "  \t</div\n"
                + " </body> \n"
                + "</html>");
        writer.flush();
    }
}
