package ru.job4j.servlets;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GreetingServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String json = req.getParameter("data");
        String name =  parse(json);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        var jsonObj = toJson("{\"greet\": \"Nice to meet you, " + name + "\"}");
        PrintWriter writer = resp.getWriter();
        writer.print(jsonObj);
        writer.flush();
    }

    public JsonObject toJson(String string) {
        return JsonParser.parseString(string).getAsJsonObject();
    }

    public String parse(String jsonLine) {
        JsonObject jsonObject = JsonParser.parseString(jsonLine).getAsJsonObject();
        return jsonObject.get("name").getAsString();
    }
}
