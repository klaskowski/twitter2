package sda.twitter2.controllers;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@WebServlet(name="AvatarController",
        urlPatterns = "/avatar")
public class AvatarController extends HttpServlet {
    private static final String DATA_DIRECTORY = "avatars";
    private static final int MAX_MEMORY_SIZE = 1024 * 1024;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 100;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = null;
        if(request.getCookies() != null)
        for(Cookie c : request.getCookies()){
            if(c.getName().equals("userId")){
                userId = c.getValue();
            }
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Sets the size threshold beyond which files are written directly to
        // disk.
        factory.setSizeThreshold(MAX_MEMORY_SIZE);

        // Sets the directory used to temporarily store files that are larger
        // than the configured size threshold. We use temporary directory for
        // java
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        // constructs the folder where uploaded file will be stored
        String uploadFolder = getServletContext().getRealPath("") + DATA_DIRECTORY;

        ServletFileUpload upload = new ServletFileUpload(factory);

        // Set overall request size constraint
        upload.setSizeMax(MAX_REQUEST_SIZE);

        try {
            // Parse the request
            Map<String,List<FileItem>> items = upload.parseParameterMap(request);
            Iterator iter = items.values().iterator().next().iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();

                if (!item.isFormField()) {
                    String filePath = uploadFolder + File.separator + userId + ".jpg";
                    File uploadedFile = new File(filePath);
                    System.out.println(filePath);
                    System.out.println(uploadedFile.createNewFile());

                    // saves the file to upload directory
                    item.write(uploadedFile);
                }
            }

            response.sendRedirect("/twitter2/");

        } catch (FileUploadException ex) {
            throw new ServletException(ex);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }

    }
}
