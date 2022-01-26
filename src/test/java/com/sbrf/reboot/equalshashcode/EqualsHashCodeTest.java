package com.sbrf.reboot.equalshashcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class EqualsHashCodeTest {

  class Car {

    String model;
    String color;
    Calendar releaseDate;
    int maxSpeed;

    @Override
    public boolean equals(Object o) {

      //Рефлексивность: объект должен равняться самому себе
      if (o == this) {
        return true;
      }

      // Сравнение с null: если о = null, то объекты не равны
      if (o == null) {
        return false;
      }

      // Нужно проверить точно ли совпадают ли классы объектов, поэтому
      // я не использую instance of, поскольку o может быть объектом класса, например,
      // SportCar, который будет наследоваться от Car и o instance of Car вернет true, а
      // наоборот наш текущий объект (this) не пройдет проверку на instance of SportCar*.
      // *Симметричность: если объект a равен b, то и объект b равно a. Симм-ть в последнем случае
      // будет нарушена.
      if (o.getClass() == this.getClass()) {
        return model.equals(((Car)o).model)
            && color.equals(((Car)o).color)
            && releaseDate.equals(((Car)o).releaseDate)
            && maxSpeed == ((Car)o).maxSpeed;
      }

      return false;

    }

    @Override
    public int hashCode() {
      int res = 0;

      // считаю хэш-код для объекта на основании
      // линейной комбинации значений, связанных с его полями.
      int modelValue = HashOfString.hashOfString(model);
      int colorValue = HashOfString.hashOfString(color);
      int releaseDateValue = releaseDate.hashCode();

      res = 7*modelValue + 3*colorValue + 19*releaseDateValue - maxSpeed;

      return res;
    }


  }

  /**
   * чтобы генерировать уникальное значение по строке можно воспользоваться след алгоритмом:
   * брать символ из строки, умножать символ на его индекс (позицию в строке) затем для
   * заданной строки все эти символы складываются.
   * Все подобным образом полученные значения для строк складываются между собой.
   * Примитивы просто можно брать в итоговую сумму по их значению.
   */
  static class HashOfString{
    static int hashOfString(String str){
      int res = 0;
      char[] chars = str.toCharArray();
      for(int i = 0; i < chars.length; i++){
        res += chars[i] * (i+1);
      }
      return res;
    }
  }

  @Test
  public void assertTrueEquals() {
    Car car1 = new Car();
    car1.model = "Mercedes";
    car1.color = "black";
    car1.releaseDate = new GregorianCalendar(2020, 0, 25);
    car1.maxSpeed = 10;

    Car car2 = new Car();
    car2.model = "Mercedes";
    car2.color = "black";
    car2.releaseDate = new GregorianCalendar(2020, 0, 25);
    car2.maxSpeed = 10;

    Assertions.assertTrue(car1.equals(car2));
  }

  @Test
  public void assertFalseEquals() {
    Car car1 = new Car();
    car1.model = "Mercedes";
    car1.color = "black";
    car1.releaseDate = new GregorianCalendar(2020, 0, 25);
    car1.maxSpeed = 10;

    Car car2 = new Car();
    car2.model = "Audi";
    car2.color = "white";
    car2.releaseDate = new GregorianCalendar(2017, 0, 25);
    car2.maxSpeed = 10;

    Assertions.assertFalse(car1.equals(car2));
  }

  @Test
  public void successEqualsHashCode() {
    Car car1 = new Car();
    car1.model = "Mercedes";
    car1.color = "black";
    car1.releaseDate = new GregorianCalendar(2020, 0, 25);
    car1.maxSpeed = 10;

    Car car2 = new Car();
    car2.model = "Mercedes";
    car2.color = "black";
    car2.releaseDate = new GregorianCalendar(2020, 0, 25);
    car2.maxSpeed = 10;

    Assertions.assertEquals(car1.hashCode(), car2.hashCode());

  }

  @Test
  public void failEqualsHashCode() {
    Car car1 = new Car();
    car1.model = "Mercedes";
    car1.color = "black";
    car1.releaseDate = new GregorianCalendar(2020, 0, 25);
    car1.maxSpeed = 10;

    Car car2 = new Car();
    car2.model = "Audi";
    car2.color = "white";
    car2.releaseDate = new GregorianCalendar(2017, 0, 25);
    car2.maxSpeed = 10;

    Assertions.assertNotEquals(car1.hashCode(), car2.hashCode());

  }


}
