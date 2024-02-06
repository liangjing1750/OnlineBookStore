package test;

import org.junit.jupiter.api.Test;
import valueobject.BookInfo;

import static org.junit.jupiter.api.Assertions.*;

public class BookInfoTest {

    @Test
    public void testBookInfoEquality() {
        BookInfo bookInfoOne = new BookInfo("1234567890", "Effective Java", "Joshua Bloch");
        BookInfo bookInfoTwo = new BookInfo("1234567890", "Effective Java", "Joshua Bloch");

        // 具有相同ISBN、标题和作者的BookInfo对象应该被视为等价的
        assertEquals(bookInfoOne, bookInfoTwo, "具有相同属性的BookInfo对象应该相等");

        // 不同的BookInfo对象
        BookInfo bookInfoThree = new BookInfo("0987654321", "Clean Code", "Robert C. Martin");
        assertNotEquals(bookInfoOne, bookInfoThree, "具有不同属性的BookInfo对象不应该相等");
    }
}
