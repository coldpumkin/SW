import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookManagerTest {

    private BookManager bookManager;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    public void setUp() {
        bookManager = new BookManager();
        System.out.println("Book Manager 생성");
        book1 = new Book(1, "자바 기초", "Jane", "2021");
        book2 = new Book(2, "소프트웨어 공학", "Tom", "2014");
        book3 = new Book(3, "분산 컴퓨팅", "Yoon", "2024");
    }

    @Test
    public void testAddBook() {
    	bookManager.addBook(book1);
        System.out.println("Book{id: " + book1.getId() + ", 제목: '" + book1.getTitle() + "', 저자: '" + book1.getAuthor() + "', 출판년도: " + book1.getPublisher() + "}가 추가되었습니다.");

        bookManager.addBook(book2);
        System.out.println("Book{id: " + book2.getId() + ", 제목: '" + book2.getTitle() + "', 저자: '" + book2.getAuthor() + "', 출판년도: " + book2.getPublisher() + "}가 추가되었습니다.");

        bookManager.addBook(book3);
        System.out.println("Book{id: " + book3.getId() + ", 제목: '" + book3.getTitle() + "', 저자: '" + book3.getAuthor() + "', 출판년도: " + book3.getPublisher() + "}가 추가되었습니다.");
    }

    @Test
    public void testSearchBook() {
        bookManager.addBook(book1);
        bookManager.addBook(book2);
        bookManager.addBook(book3);

        assertEquals(book1, bookManager.searchBook("자바 기초"));
        System.out.println("Book{id: " + book1.getId() + ", 제목: '" + book1.getTitle() + "', 저자: '" + book1.getAuthor() + "', 출판년도: " + book1.getPublisher() + "} 검색 결과가 출력되었습니다.");

        assertEquals(book2, bookManager.searchBook("소프트웨어 공학"));
        System.out.println("Book{id: " + book2.getId() + ", 제목: '" + book2.getTitle() + "', 저자: '" + book2.getAuthor() + "', 출판년도: " + book2.getPublisher() + "} 검색 결과가 출력되었습니다.");

        assertEquals(book3, bookManager.searchBook("분산 컴퓨팅"));
        System.out.println("Book{id: " + book3.getId() + ", 제목: '" + book3.getTitle() + "', 저자: '" + book3.getAuthor() + "', 출판년도: " + book3.getPublisher() + "} 검색 결과가 출력되었습니다.");
    }

    @Test
    public void testRemoveBook() {
        bookManager.addBook(book1);
        bookManager.addBook(book2);
        bookManager.addBook(book3);

        boolean removed1 = bookManager.removeBook(1);
        assertTrue(removed1);
        System.out.println("책의 ID(1)로 도서를 찾을 수 없습니다.");

        Book result1 = bookManager.searchBook("자바 기초");
        assertNull(result1);

        boolean removed2 = bookManager.removeBook(2);
        assertTrue(removed2);
        System.out.println("책의 ID(2)로 도서를 찾을 수 없습니다.");
        
    }
}
