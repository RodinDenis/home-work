package com.sbrf.reboot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;

public class JSONUtils {

  public static String toJSON(Request request) throws JsonProcessingException {
    String res;
    ObjectMapper objectMapper = new ObjectMapper();
    res = objectMapper.writeValueAsString(request);
    return res;
  }

  public static String toJSON(Response response) throws JsonProcessingException {
    String res;
    ObjectMapper objectMapper = new ObjectMapper();
    res = objectMapper.writeValueAsString(response);
    return res;
  }

  public static Request JSONtoRequest(String jsonStr) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(jsonStr, Request.class);
  }

  public static Response JSONtoResponse(String jsonStr) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(jsonStr, Response.class);
  }
}
