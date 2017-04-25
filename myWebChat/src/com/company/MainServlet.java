package com.company;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hackeru on 4/23/2017.
 */
public class MainServlet extends javax.servlet.http.HttpServlet {
    String message = "1234";
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String queryString = request.getQueryString();
        Map<String, String> qs = new HashMap<>();
        if(queryString != null){
            String[] keyValues = queryString.split("&");
            for(String keyValue : keyValues){
                String[] keyValuePair = keyValue.split("=");
                if(keyValuePair.length != 2)
                    continue;
                qs.put(keyValuePair[0], keyValuePair[1]);
            }
        }

        String action = qs.get("action");
        if (action.equals("get")){
            response.getWriter().write(message);
        }
        if (action.equals("send")){
            message = qs.get("message");
        }

    }
}
