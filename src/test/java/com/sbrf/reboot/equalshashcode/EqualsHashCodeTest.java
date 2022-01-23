package com.sbrf.reboot.equalshashcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class EqualsHashCodeTest {

    class Car {
        String model;
        String color;
        Calendar releaseDate;
        int maxSpeed;

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 41 * hash + Objects.hashCode(this.model);
            hash = 41 * hash + Objects.hashCode(this.color);
            hash = 41 * hash + Objects.hashCode(this.releaseDate);
            hash = 41 * hash + this.maxSpeed;
            return hash;
        }

        @Override
        public boolean equals(Object o) {

            //Рефлексивность: объект должен равняться самому себе
            if (this == o)
                return true;

            // Сравнение null
            if (o == null)
                return false;

            Car toCompare = (Car) o;

            // Далее - сравнение значимых полей:
            if (!this.model.equals(toCompare.model))
                return false;


            if (!this.color.equals(toCompare.color))
                return false;


            if (!this.releaseDate.equals(toCompare.releaseDate))
                return false;


            return true;
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

    // При равенстве HashCode для двух объектов, Equals точно должен возвращать true
    @Test
    public void trueHashCodeThenTrueEquals() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        boolean hashCompareResult = car1.hashCode() == car2.hashCode();

        Assertions.assertEquals(hashCompareResult, car1.equals(car2));

    }


    @Test
    public void falseHashCodeThenFalseEquals() {
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

        boolean hashCompareResult = car1.hashCode() == car2.hashCode();

        Assertions.assertEquals(hashCompareResult, car1.equals(car2));

    }

}
