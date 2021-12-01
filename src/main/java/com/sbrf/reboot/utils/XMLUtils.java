package com.sbrf.reboot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;
import com.sbrf.reboot.dto.Temp;

import java.util.Collection;

public class XMLUtils {
    public static  <T extends Temp> String toXML(T request) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.writeValueAsString(request);
    }

    public static Request XMLtoRequest(String s) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(s, Request.class);
    }

    public static Response XMLtoResponse(String s) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(s, Response.class);
    }
}
