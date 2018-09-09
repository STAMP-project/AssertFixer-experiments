package presentation;


import model.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import persistent.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUploadController extends HttpServlet {
    private CarStorage storage = CarStorage.getInstance();
    private EngineStorage engineStorage = EngineStorage.getInstance();
    private BrandStorage brandStorage = BrandStorage.getInstance();
    private CarBodyStorage carBodyStorage = CarBodyStorage.getInstance();
    private TransmissionStorage transmissionStorage = TransmissionStorage.getInstance();
    private LoginStorage loginStorage = LoginStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> parameters = new HashMap<>();
        Photo photo = null;
        String foto = "";
        String path = "C:\\Users\\rig0\\projects\\azuryanov\\azuryanov\\123\\carboard\\webapp\\resources\\";
        try {
            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            for (FileItem item : items) {
                if (item.isFormField()) {
                    String fieldName = item.getFieldName();
                    String fieldValue = item.getString();
                    parameters.put(fieldName, fieldValue);
                } else {
                   foto = item.getName();
                   if (foto.length() > 0) {
                       item.write(new File(path + foto));
                       photo = new Photo();
                       photo.setName(foto);
                       photo.setImage("/resources/" + foto);
                   }
                }
            }
            Advertisement advertisement = new Advertisement();

            advertisement.setBrand(brandStorage.find(parameters.get("brandname")));
            advertisement.setEngine(engineStorage.find(parameters.get("enginename")));
            advertisement.setTransmission(transmissionStorage.find(parameters.get("transmissionname")));
            advertisement.setCarBody(carBodyStorage.find(parameters.get("carbodyname")));
            HttpSession session = request.getSession();
            if (session.getAttribute("login") != null) {
                advertisement.setLogin(loginStorage.find((String) session.getAttribute("login")));
            }
            if (photo != null) {
                advertisement.setPhoto(photo);
            }
            advertisement.setText(parameters.get("textname"));
            advertisement.setPrice(Integer.parseInt(parameters.get("pricename")));
            storage.add(advertisement, photo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect(String.format("%s/", request.getContextPath()));
    }
}
