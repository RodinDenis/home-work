package com.sbrf.reboot.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionsTest {


    /*
     * Задача.
     * Имеется список лучших студентов вуза.
     *
     * 1. Иванов
     * 2. Петров
     * 3. Сидоров
     *
     * В новом семестре по результатам подсчетов оценок в рейтинг на 1 место добавился новый студент - Козлов.
     * Теперь в рейтинге участвуют 4 студента.
     * (Предполагаем что в рейтинг можно попасть только получив достаточное количество балов, что бы занять 1 место).
     *
     * Вопрос.
     * Какую коллекцию из Collections framework вы предпочтете для текущего хранения и использования списка студентов?
     *
     * Проинициализируйте students, добавьте в нее 4 фамилии студентов что бы тест завершился успешно.
     *
     * Мое решение: в данной задаче мы должны оптимизировать добавление студента в начало коллекции и при этом у нас должен
     * соблюдаться порядок. Это нам говорит о том, что мы должны использовать коллекцию LinkedList, поскольку эта
     * коллекция представляет из себя связный список, а значит при добавлении элемента в начало нам не надо сдвигать весь
     * изначальный список на одну позицию, напротив, мы не трогаем изначальные элементы, и добавляем всего лишь
     * ссылку для нового студента на первого студента исходной коллекции, и наоборот.
     *
     */
    @Test
    public void addStudentToRating() {

        List<String> students = new LinkedList<>();

        students.add("Иванов");
        students.add("Петров");
        students.add("Сидоров");

        students.add("Умнов");
        assertEquals(4, students.size());
    }

    /*
     * Задача.
     * Вы коллекционируете уникальные монеты.
     * У вас имеется специальный бокс с секциями, куда вы складываете монеты в хаотичном порядке.
     *
     * Вопрос.
     * Какую коллекцию из Collections framework вы предпочтете использовать для хранения монет в боксе.
     *
     * Проинициализируйте moneyBox, добавьте в нее 10 монет что бы тест завершился успешно.
     *
     * Решение.
     * Поскольку нам нужны уникальные монеты и есть вероятность повторения приходящих монет, то мы должны
     * использовать Set. Поскольку порядок нам не важен, а нужен лишь уникальный отбор, то
     * используем HashSet, поскольку он дополнительно не тратит ресурсы и время на сортировку или
     * упорядочивание.
     */
    @Test
    public void addMoneyToBox() {

        Set<Integer> moneyBox = new HashSet<>();

        for(int i = 1; i <= 10; ++i) {
            moneyBox.add(i);
        }

        assertEquals(10, moneyBox.size());
    }

    /*
     * Задача.
     * Имеется книжная полка.
     * Периодически вы берете книгу для чтения, затем кладете ее на свое место.
     *
     * Вопрос.
     * Какую коллекцию из Collections framework вы предпочтете использовать для хранения книг.
     *
     * Проинициализируйте bookshelf, добавьте в нее 3 книги что бы тест завершился успешно.
     *
     * Решение.
     * Поскольку мы берем книгу из конкретного места, то есть знаем ее позицию,
     * и при этом ее место за ней и остается, то мы должны использовать ArrayList, т к он
     * достаточным образом без лишнего покрывает все наши нужды.
     */
    @Test
    public void addBookToShelf() {
        class Book {
        }

        List<Book> bookshelf = new ArrayList<>();

        bookshelf.add(new Book());
        bookshelf.add(new Book());
        bookshelf.add(new Book());

        assertEquals(3, bookshelf.size());
    }


    /*
     * Задача.
     * Имеется школьная столовая и желающие очень сильно покушать школьники.
     * Поскольку школьников много, то нужно ввести определенный порядок, поэтому
     * перед входом в столовую стоят люди, которые должны из этой толпы запускать школьников
     * таким образом, чтоб первыми заходили более младшие из толпы (старшинство по классам).
     *
     * Вопрос.
     * Какую коллекцию из Collections framework можно использовать для входа в столовую.
     *
     * Проинициализируйте studentsInBuffet, добавьте 5 школьников что бы тест завершился успешно.
     *
     * Решение.
     * Поскольку из огромный толпы должны должны отбирать школьников по приоритету (по классу)
     * то логичнее всего будет всех школьников хранить в PriorityQueue, т к данная коллекция
     * учитывает приоритет при извлечении из нее элементов.
     */
    @Test
    public void addPupilToBuffet() {
        class Pupil{
            int course;

            public Pupil(int course){
                this.course = course;
            }

            public int getCourse() {
                return course;
            }
        }
        Queue<Pupil> studentsInBuffet = new PriorityQueue<>(new Comparator<Pupil>(){
            @Override
            public int compare(Pupil p1, Pupil p2) {
                return p1.getCourse() - p2.getCourse();
            }
        });

        studentsInBuffet.add(new Pupil(4));
        studentsInBuffet.add(new Pupil(2));
        studentsInBuffet.add(new Pupil(9));
        studentsInBuffet.add(new Pupil(1));
        studentsInBuffet.add(new Pupil(7));

        assertEquals(5, studentsInBuffet.size());
    }

}
