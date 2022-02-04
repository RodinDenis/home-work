package com.sbrf.reboot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;

public class XMLUtils {

  public static String toXML(Request request) throws JsonProcessingException {
    String xml;
    XmlMapper xmlMapper = new XmlMapper();
    xml = xmlMapper.writeValueAsString(request);
    return xml;
  }

  public static String toXML(Response response) throws JsonProcessingException {
    String xml;
    XmlMapper xmlMapper = new XmlMapper();
    xml = xmlMapper.writeValueAsString(response);
    return xml;
  }

  public static Request XMLtoRequest(String xml) throws JsonProcessingException {
    XmlMapper xmlMapper = new XmlMapper();
    return xmlMapper.readValue(xml, Request.class);

  }

  public static Response XMLtoResponse(String xml) throws JsonProcessingException {
    XmlMapper xmlMapper = new XmlMapper();
    return xmlMapper.readValue(xml, Response.class);
  }
}
