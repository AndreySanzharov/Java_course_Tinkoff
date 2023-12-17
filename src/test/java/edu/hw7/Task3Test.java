package edu.hw7;

import edu.hw7.Task3.CachedPersonDatabase;
import edu.hw7.Task3.Person;
import edu.hw7.Task3.PersonDatabase;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {

    @Test
    void testAddAndFind() {
        PersonDatabase database = new CachedPersonDatabase();

        Person person1 = new Person(1, "John Doe", "123 Main St", "555-1234");
        Person person2 = new Person(2, "Jane Smith", "456 Oak St", "555-5678");

        // Добавляем персоны в базу данных
        database.add(person1);
        database.add(person2);

        // Проверяем, что они успешно добавлены
        List<Person> johnDoes = database.findByName("John Doe");
        assertEquals(1, johnDoes.size());
        assertEquals(person1, johnDoes.get(0));

        List<Person> janeSmiths = database.findByName("Jane Smith");
        assertEquals(1, janeSmiths.size());
        assertEquals(person2, janeSmiths.get(0));

        // Проверяем, что уникальность имен сохраняется
        assertEquals(1, johnDoes.size());
        assertEquals(1, janeSmiths.size());
    }

    @Test
    void testDelete() {
        PersonDatabase database = new CachedPersonDatabase();

        Person person1 = new Person(1, "John Doe", "123 Main St", "555-1234");
        Person person2 = new Person(2, "Jane Smith", "456 Oak St", "555-5678");

        // Добавляем персоны в базу данных
        database.add(person1);
        database.add(person2);

        // Удаляем одну персону
        database.delete(1);

        // Проверяем, что первая персона удалена, а вторая осталась
        assertEquals(0, database.findByName("John Doe").size());
        assertEquals(1, database.findByName("Jane Smith").size());
    }

    @Test
    void testFindByNonexistentAttributes() {
        PersonDatabase database = new CachedPersonDatabase();

        Person person1 = new Person(1, "John Doe", "123 Main St", "555-1234");

        // Добавляем персону в базу данных
        database.add(person1);

        // Проверяем, что не существующие атрибуты возвращают пустые списки
        assertTrue(database.findByName("Nonexistent Name").isEmpty());
        assertTrue(database.findByAddress("Nonexistent Address").isEmpty());
        assertTrue(database.findByPhone("Nonexistent Phone").isEmpty());
    }
}
