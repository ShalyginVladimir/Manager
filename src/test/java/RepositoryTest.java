import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @Test
    public void testRepositoryAdd() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Smartphone smartphone4 = new Smartphone(4, "T500", 200, "SONY");
        Smartphone smartphone5 = new Smartphone(5, "IPhone14", 300, "Apple");
        Smartphone smartphone6 = new Smartphone(6, "T600", 200, "SONY");

        repo.add(smartphone4);
        repo.add(smartphone5);
        repo.add(smartphone6);

        Product[] expected = {smartphone4, smartphone5, smartphone6};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void Model() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Smartphone smartphone4 = new Smartphone(4, "T500", 200, "SONY");
        Smartphone smartphone5 = new Smartphone(5, "IPhone14", 300, "Apple");
        Smartphone smartphone6 = new Smartphone(6, "T600", 200, "SONY");

        repo.add(smartphone4);
        repo.add(smartphone5);
        repo.add(smartphone6);

        Product[] expected = {smartphone6};
        Product[] actual = manager.searchBy("T600");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void Price() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Smartphone smartphone4 = new Smartphone(4, "T500", 200, "SONY");
        Smartphone smartphone5 = new Smartphone(5, "IPhone14", 300, "Apple");
        Smartphone smartphone6 = new Smartphone(6, "T600", 200, "SONY");

        repo.add(smartphone4);
        repo.add(smartphone5);
        repo.add(smartphone6);

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("SAMSUNG");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByid() {
        Repository repo = new Repository();

        Book book1 = new Book(1, "Harri Potter 1", 100, "Rowling");
        Book book2 = new Book(2, "War and Peace", 100, "Tolstoy");
        Book book3 = new Book(3, "Harri Potter 2", 100, "Rowling");
        Smartphone smartphone4 = new Smartphone(4, "T500", 200, "SONY");
        Smartphone smartphone5 = new Smartphone(5, "IPhone14", 300, "Apple");
        Smartphone smartphone6 = new Smartphone(6, "T600", 200, "SONY");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(smartphone4);
        repo.add(smartphone5);
        repo.add(smartphone6);
        repo.removeByid(2);
        repo.removeByid(5);

        Product[] expected = {book1, book3, smartphone4, smartphone6};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}