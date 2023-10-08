package com.barokah.belajarwebservlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@WebServlet(urlPatterns = "/form-upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String htmlPath = this.getClass().getResource("/html/form-upload.html").getPath();
        htmlPath = htmlPath.replace("%20", " ");

        Path path = Path.of(htmlPath);
        String html = Files.readString(path);

        resp.getWriter().println(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Part profile = req.getPart("profile");

        String fileName = UUID.randomUUID() + profile.getSubmittedFileName();
        String uploadLocation = "upload/" + fileName;
        Path uploadPath = Path.of(uploadLocation);

        Files.copy(profile.getInputStream(), uploadPath);

        String htmlFile = this.getClass().getResource("/html/upload-post.html").getPath();
        htmlFile = htmlFile.replace("%20"," ");

        Path htmlPath = Path.of(htmlFile);

        String html = Files.readString(htmlPath);
        html = html.replace("$name", name).replace("$profile",fileName);

        resp.getWriter().println(html);
    }
}
