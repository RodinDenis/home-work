package com.sbrf.reboot.functionalinterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sbrf.reboot.functionalinterface.FunctionalInterfaceTest.SomeObject;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    /**
     * Кастомный функ-й интерфейс для конвертирования объектов в XML.
     */
    @FunctionalInterface
    interface ObjectToXMLFunction<T> {
        String applyAsXML(T t) throws JsonProcessingException;
    }

    static class ListConverter<T> {
        public List<String> toJsonsList(@NonNull List<T> someObjects, ObjectToJsonFunction<T> objectToJsonFunction)
            throws JsonProcessingException {
            List<String> result = new ArrayList<>();
            if (someObjects.isEmpty())
                throw new IllegalArgumentException("The list is empty");

            //add code here...
            for(T elem : someObjects){
                result.add(objectToJsonFunction.applyAsJson(elem));
            }

            return result;
        }

        /**
         * Добавлен мой кастомный метод для конвертирования объектов в XML.
         * По сути, он ничем не отличался бы от метода выше, поэтому я создал
         * дополнительный функциональный интерфейс ObjectToXMLFunction<T>
         */
        public List<String> toXMLsList(@NonNull List<T> someObjects, ObjectToXMLFunction<T> objectToXMLFunction)
            throws JsonProcessingException {
            List<String> result = new ArrayList<>();
            if (someObjects.isEmpty())
                throw new IllegalArgumentException("The list is empty");

            //add code here...
            for(T elem : someObjects){
                result.add(objectToXMLFunction.applyAsXML(elem));
            }

            return result;
        }
    }

    @Test
    public void successCallFunctionalInterface() throws JsonProcessingException {
        ListConverter<SomeObject> ListConverter = new ListConverter<>();

        ObjectToJsonFunction<SomeObject> objectToJsonFunction = someObject -> {
            //add code here...
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(someObject);
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


    /**
     * Проверка конвертирования в XML.
     */
    @Test
    public void successCallFunctionalInterfaceXML() throws JsonProcessingException {
        ListConverter<SomeObject> ListConverter = new ListConverter<>();

        ObjectToXMLFunction<SomeObject> objectToXmlFunction = someObject -> {
            // my code...
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.writeValueAsString(someObject);
        };

        List<String> strings = ListConverter.toXMLsList(
            Arrays.asList(
                new SomeObject("Object-1"),
                new SomeObject("Object-2")
            ),
            objectToXmlFunction
        );

        Assertions.assertTrue(strings.contains("<SomeObject><objectName>Object-1</objectName></SomeObject>"));
        Assertions.assertTrue(strings.contains("<SomeObject><objectName>Object-2</objectName></SomeObject>"));
    }

}
