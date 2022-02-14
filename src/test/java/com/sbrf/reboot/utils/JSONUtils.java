package com.sbrf.reboot.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;
import lombok.SneakyThrows;

public class JSONUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    public static String toJSON(Request request) {

        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    public static String toJSON(Response response) {
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(response);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonString;
    }


    @SneakyThrows
    public static Request JSONtoRequest(String json){
        return mapper.readValue(json, Request.class);
    }

    @SneakyThrows
    public static Response JSONtoResponse(String json){
        return mapper.readValue(json, Response.class);
    }
}
