package com.sbrf.reboot.concurrentmodify;

import java.util.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RemoveElementWithoutErrorsTest {

  List<Integer> list = null;
  final List<Integer> res = new ArrayList<Integer>() {{
    add(1);
    add(2);
    add(4);
  }};

  @BeforeEach
  public void init() {

    list = new ArrayList<Integer>() {{
      add(1);
      add(2);
      add(3);
      add(4);
    }};
  }

  @Test
  public void successConcurrentModificationException() {

    assertThrows(ConcurrentModificationException.class, () -> {

      for (Integer integer : list) {
        list.remove(1);
      }

    });
  }

  /**
   * Способ 1: перебор и удаление явно через итератор.
   */
  @Test
  public void successRemoveElementWithoutErrors1() {

    Iterator<Integer> i = list.iterator();

    while (i.hasNext()) {
      Integer listElem = i.next();
      if (listElem == 3) {
        i.remove();
      }
    }

    assertEquals(res, list);
  }

  /**
   * Способ 2: создать временный лист, в который будут добавлены те элементы исходного листа,
   * которые нам надо удалить, и удалить эти элементы после обхода исходного листа через
   * removeAll()
   */
  @Test
  public void successRemoveElementWithoutErrors2() {

    List<Integer> tempList = new ArrayList<>();

    for (Integer elem : list) {
      if (elem == 3) {
        tempList.add(elem);
      }
    }

    list.removeAll(tempList);

    assertEquals(res, list);
  }

  /**
   * Способ 3: через нововведение в Java 8 - removeIf().
   */
  @Test
  public void successRemoveElementWithoutErrors3() {

    list.removeIf(i -> i == 3);

    assertEquals(res, list);
  }
}
