package com.example.bookstore.domain.test.order;


import com.example.bookstore.domain.order.valueobject.BookInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BookInfoTest {

    @Test
    public void testBookInfoEquality() {
        BookInfo bookInfoOne = new BookInfo("Effective Java", "Joshua Bloch");
        BookInfo bookInfoTwo = new BookInfo("Effective Java", "Joshua Bloch");

        // 具有相同ISBN、标题和作者的BookInfo对象应该被视为等价的
        assertEquals(bookInfoOne, bookInfoTwo, "具有相同属性的BookInfo对象应该相等");

        // 不同的BookInfo对象
        BookInfo bookInfoThree = new BookInfo("Clean Code", "Robert C. Martin");
        assertNotEquals(bookInfoOne, bookInfoThree, "具有不同属性的BookInfo对象不应该相等");
    }
}
