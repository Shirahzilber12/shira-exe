package com.company;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hackeru on 4/23/2017.
 */
public class MainServlet extends javax.servlet.http.HttpServlet {
    String message = "1234";
    ArrayList<String> arrayList=new ArrayList<>();
    int counter = 0;


    @Override
    public void init() throws ServletException {
        super.init();
    }

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

        //get
        if (action.equals("get")){
            String numOfReadMessages=qs.get("num");
            int num = Integer.valueOf(numOfReadMessages);
            for (int i = num ; i <counter ; i++) {
                response.getWriter().write(arrayList.get(i)+'^');
            }
        }
        //send
        if (action.equals("send")){
            arrayList.add( qs.get("message"));
            counter++;
        }

    }
}
