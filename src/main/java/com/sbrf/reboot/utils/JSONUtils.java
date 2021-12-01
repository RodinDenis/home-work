package com.sbrf.reboot.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;
import com.sbrf.reboot.dto.Temp;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class JSONUtils {
    /*сначала я сделала два метода с параметрами Response и Request
    * Но потом интереса ради попробовала объединить их в один, не зря же мы уже проходили дженерики
    * Не знаю, насколько это осмысленно*/
    public static <T extends Temp> String toJSON(T request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, request);
        return writer.toString();
    }

/*    public static String toJSON(Response response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, response);
        return writer.toString();
    }*/

    public static Request JSONtoRequest(String jsonString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringReader reader = new StringReader(jsonString);
        return mapper.readValue(reader, Request.class);
    }

    @SneakyThrows
    public static Response JSONtoResponse(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        StringReader reader = new StringReader(jsonString);
        return mapper.readValue(reader, Response.class);
    }
}
