package com.barokah.belajarwebservlet.servlet;

import com.barokah.belajarwebservlet.model.SayHelloRequest;
import com.barokah.belajarwebservlet.util.JsonUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/api/say-hello")
public class RequestBodyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SayHelloRequest sayHelloRequest = JsonUtil.getObjectMapper().readValue(req.getReader(), SayHelloRequest.class);
        String sayHello = "Hello " + sayHelloRequest.getFirstName() + " " + sayHelloRequest.getLastName();

        Map<String, String> response = Map.<String, String>of(
                "data", sayHello
        );

        String jsonReasponse = JsonUtil.getObjectMapper().writeValueAsString(response);

        resp.setHeader("Content-Type","application/json");
        resp.getWriter().println(jsonReasponse);
    }
}
