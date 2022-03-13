package com.sbrf.reboot.concurrentmodify;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RemoveElementWithoutErrorsTest {

    @Test
    public void successConcurrentModificationException() {

        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};

        assertThrows(ConcurrentModificationException.class, () -> {

            for (Integer integer : list) {
                list.remove(1);
            }


        });

    }

    @Test
    public void successRemoveElementWithoutErrors() {
        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};

        assertDoesNotThrow(() -> {

            list.stream().filter(i -> list.indexOf(i) == 1).collect(Collectors.toList());

        });

    }


    @Test
    public void successRemoveElementWithoutErrors1() {
        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};

        List<Integer> listToRemove = new ArrayList();

        assertDoesNotThrow(() -> {

            for (Integer integer : list) {
                if (list.indexOf(integer) == 1) {
                    listToRemove.add(integer);
                }
            }
            list.removeAll(listToRemove);
        });

    }

}
