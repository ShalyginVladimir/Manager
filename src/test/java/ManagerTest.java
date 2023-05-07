import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    public void testAdd() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Harri Potter 1", 100, "Rowling");
        Book book2 = new Book(2, "War and Peace", 100, "Tolstoy");
        Book book3 = new Book(3, "Harri Potter 2", 100, "Rowling");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearch() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Harri Potter 1", 100, "Rowling");
        Book book2 = new Book(2, "War and Peace", 100, "Tolstoy");
        Book book3 = new Book(3, "Harri Potter 2", 100, "Rowling");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book3};
        Product[] actual = manager.searchBy("Potter");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void Book() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Harri Potter 1", 100, "Rowling");
        Book book2 = new Book(2, "War and Peace", 100, "Tolstoy");
        Book book3 = new Book(3, "Harri Potter 2", 100, "Rowling");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Peace");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void Name() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Harri Potter 1", 100, "Rowling");
        Book book2 = new Book(2, "War and Peace", 100, "Tolstoy");
        Book book3 = new Book(3, "Harri Potter 2", 100, "Rowling");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Russian history");

        Assertions.assertArrayEquals(expected, actual);
    }

}