package com.sbrf.reboot.functionalinterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalInterfaceTest {

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    static class SomeObject {
        private String objectName;
    }

    @FunctionalInterface
    interface ObjectToJsonFunction<T> {
        String applyAsJson(T t) throws JsonProcessingException;
    }

    static class ListConverter<T> {
        public List<String> toJsonsList(@NonNull List<T> someObjects, ObjectToJsonFunction<T> objectToJsonFunction) {
            List<String> result = new ArrayList<>();
            if (someObjects.isEmpty())
                throw new IllegalArgumentException("The list is empty");

            result = someObjects.stream().map(i-> {
                try {
                    return objectToJsonFunction.applyAsJson(i);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                return null;
            }).collect(Collectors.toList());

            return result;
        }
    }

    @Test
    public void successCallFunctionalInterface() {
        ListConverter<SomeObject> ListConverter = new ListConverter<>();

        ObjectToJsonFunction<SomeObject> objectToJsonFunction = someObject -> {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = null;
            try {
                jsonString = mapper.writeValueAsString(someObject);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return jsonString;
        };

        List<String> strings = ListConverter.toJsonsList(
                Arrays.asList(
                        new SomeObject("Object-1"),
                        new SomeObject("Object-2")
                ),
                objectToJsonFunction
        );

        Assertions.assertTrue(strings.contains("{\"objectName\":\"Object-1\"}"));
        Assertions.assertTrue(strings.contains("{\"objectName\":\"Object-2\"}"));
    }

}
