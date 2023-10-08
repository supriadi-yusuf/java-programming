package com.barokah.belajarwebservlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.stream.Stream;

@WebServlet(urlPatterns = "/request-query")
public class RequestQuery extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] numbers = req.getParameterValues("number");
        long sum = Stream.<String>of(numbers).mapToLong(Long::parseLong).sum();
        resp.getWriter().println("Total numbers is " + sum);
    }
}
