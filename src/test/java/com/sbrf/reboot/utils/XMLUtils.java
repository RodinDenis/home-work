package com.sbrf.reboot.utils;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;
import lombok.SneakyThrows;

public class XMLUtils {

   private static XmlMapper mapper = new XmlMapper();

    public static String toXML(Request request) {

        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    public static String toXML(Response response) {

        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(response);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    @SneakyThrows
    public static Request XMLtoRequest(String xml){
        return mapper.readValue(xml, Request.class);
    }

    @SneakyThrows
    public static Response XMLtoResponse(String xml){
        return mapper.readValue(xml, Response.class);
    }
}
