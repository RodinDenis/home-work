package com.sbrf.reboot.streams;

import java.util.ArrayList;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamTest {

  /*
   * Отсортируйте коллекцию integers по возрастанию. Используйте Stream.
   */
  @Test
  public void sortedListStream() {
    List<Integer> integers = Arrays.asList(6, 9, 8, 3);

    List<Integer> expectedIntegers = Arrays.asList(3, 6, 8, 9);

    List<Integer> actualIntegers = integers.stream()
        .sorted((e1, e2) -> e1 > e2 ? 1 : e1.equals(e2) ? 0 : -1).collect(
            Collectors.toList());

    assertEquals(expectedIntegers, actualIntegers);
  }

  /*
   * Отфильтруйте коллекцию integers.
   * В коллекции должны остаться только те числа, которые делятся без остатка на 2.  Используйте Stream.
   */
  @Test
  public void filteredListStream() {
    List<Integer> integers = Arrays.asList(6, 9, 8, 3);

    List<Integer> expectedIntegers = Arrays.asList(6, 8);

    List<Integer> actualIntegers = integers.stream().filter(e -> e % 2 == 0).collect(
        Collectors.toList());

    assertEquals(expectedIntegers, actualIntegers);

  }

  /*
   * Отфильтруйте и отсортируйте коллекцию books.
   * Получите коллекцию, в которой будут только книги от автора "Maria", отсортированные по цене.
   * Используйте Stream.
   */
  @AllArgsConstructor
  @EqualsAndHashCode
  class Book {

    private String name;
    private String author;
    private BigDecimal price;
  }

  @Test
  public void sortedAndFilteredBooks() {
    List<Book> books = Arrays.asList(
        new Book("Trees", "Maria", new BigDecimal(900)),
        new Book("Animals", "Tom", new BigDecimal(500)),
        new Book("Cars", "John", new BigDecimal(200)),
        new Book("Birds", "Maria", new BigDecimal(100)),
        new Book("Flowers", "Tom", new BigDecimal(700))

    );
    List<Book> expectedBooks = Arrays.asList(
        new Book("Birds", "Maria", new BigDecimal(100)),
        new Book("Trees", "Maria", new BigDecimal(900))

    );

    List<Book> actualBooks = books.stream().filter(book -> book.author.equals("Maria"))
        .sorted((b1, b2) -> b1.price.compareTo(b2.price)).collect(
            Collectors.toList()); //add code here

    assertEquals(expectedBooks, actualBooks);

  }

  /*
   * Получите измененную коллекцию contracts.
   * Получите коллекцию, в которой будет тот же набор строк, только у каждой строки появится префикс "M-".
   * Используйте Stream.
   */
  @Test
  public void modifiedList() {
    List<String> contracts = Arrays.asList("NCC-1-CH", "NCC-2-US", "NCC-3-NH");

    List<String> expectedContracts = Arrays.asList("M-NCC-1-CH", "M-NCC-2-US", "M-NCC-3-NH");

    List<String> actualContracts = contracts.stream().map(e -> "M-" + e)
        .collect(Collectors.toList()); //add code here

//        Еще один вариант решения.
//        List<String> actualContracts = new ArrayList<>();
//        contracts.forEach(e1 -> {actualContracts.add("M-" + e1);});

    assertEquals(expectedContracts, actualContracts);

  }

  class Car {

    String model;
    Integer price;


    Car(String model, Integer price) {
      this.model = model;
      this.price = price;
    }
  }

  // Доп задание.
  // Вернуть количество машин марки BMW.
  // Отфильтровать коллекцию машин и вернуть количество BMW.
  @Test
  public void filterCountTest() {
    List<Car> cars = new ArrayList<Car>() {{
      add(new Car("Mercedes", 5000));
      add(new Car("Toyota", 1300));
      add(new Car("BMW", 15_000));
      add(new Car("Hummer", 10_000));
      add(new Car("Honda", 1000));
      add(new Car("BMW", 7600));
      add(new Car("Jeep", 9500));
      add(new Car("Bugatti", 50_000));
      add(new Car("BMW", 4000));
    }};

    long expectedNumOfBMW = 3;

    long actualNumOfBMW = cars.stream().filter(e -> e.model.equals("BMW")).count();

    assertEquals(expectedNumOfBMW, actualNumOfBMW);
  }

  // Доп задание.
  // Вернуть цену самой дорогой BMW.
  // Отфильтровать коллекцию машин и вернуть максимум.
  @Test
  public void maxPrice() {
    List<Car> cars = new ArrayList<Car>() {{
      add(new Car("Mercedes", 5000));
      add(new Car("Toyota", 1300));
      add(new Car("BMW", 15_000));
      add(new Car("Hummer", 10_000));
      add(new Car("Honda", 1000));
      add(new Car("BMW", 7600));
      add(new Car("Jeep", 9500));
      add(new Car("Bugatti", 50_000));
      add(new Car("BMW", 4000));
    }};

    long expectedPrice = 15_000;

    long actualPrice = cars.stream().filter(e -> e.model.equals("BMW"))
        .max((e1, e2) -> Long.compare(e1.price, e2.price)).get().price;

    assertEquals(expectedPrice, actualPrice);
  }
}
