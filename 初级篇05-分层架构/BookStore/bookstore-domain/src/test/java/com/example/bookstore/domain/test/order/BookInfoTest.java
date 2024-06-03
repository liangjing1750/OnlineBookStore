package com.example.bookstore.domain.test.order;


import com.example.bookstore.domain.order.valueobject.BookInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BookInfoTest {

    @Test
    public void testBookInfoConstructor() {
        BookInfo bookInfo = new BookInfo("Effective Java", "Joshua Bloch", "123");

        // 测试BookInfo对象的属性值
        assertEquals("Effective Java", bookInfo.getTitle(), "BookInfo对象的title属性应该等于'Effective Java'");
        assertEquals("Joshua Bloch", bookInfo.getAuthor(), "BookInfo对象的author属性应该等于'Joshua Bloch'");
    }

    @Test
    public void testBookInfoToString() {
        BookInfo bookInfo = new BookInfo("Effective Java", "Joshua Bloch", "123");

        // 测试BookInfo对象的toString方法
        assertEquals("BookInfo{title='Effective Java', author='Joshua Bloch', isbn='123'}", bookInfo.toString(), "BookInfo对象的toString方法应该返回正确的字符串");
    }

    @Test
    public void testBookInfoHashCode() {
        BookInfo bookInfoOne = new BookInfo("Effective Java", "Joshua Bloch", "123");
        BookInfo bookInfoTwo = new BookInfo("Effective Java", "Joshua Bloch", "123");

        // 具有相同ISBN、标题和作者的BookInfo对象应该具有相同的hashCode
        assertEquals(bookInfoOne.hashCode(), bookInfoTwo.hashCode(), "具有相同属性的BookInfo对象应该具有相同的hashCode");
    }

    @Test
    public void testBookInfoEqualityWithNull() {
        BookInfo bookInfo = new BookInfo("Effective Java", "Joshua Bloch", "123");

        // 与null进行比较，应该返回false
        assertNotEquals(bookInfo, null, "BookInfo对象与null不应该相等");
    }

    @Test
    public void testBookInfoEqualityWithDifferentType() {
        BookInfo bookInfo = new BookInfo("Effective Java", "Joshua Bloch", "123");

        // ���不同类型的对象进行比较，应该返回false
        assertNotEquals(bookInfo, "Effective Java", "BookInfo对象与String对象不应该相等");
    }

    @Test
    public void testBookInfoEqualityWithSameObject() {
        BookInfo bookInfo = new BookInfo("Effective Java", "Joshua Bloch", "123");

        // 与同一个对象进行比较，应该返回true
        assertEquals(bookInfo, bookInfo, "BookInfo对象与自身应该相等");
    }

    @Test
    public void testBookInfoEquality() {
        BookInfo bookInfoOne = new BookInfo("Effective Java", "Joshua Bloch", "123");
        BookInfo bookInfoTwo = new BookInfo("Effective Java", "Joshua Bloch", "123");

        // 具有相同ISBN、标题和作者的BookInfo对象应该被视为等价的
        assertEquals(bookInfoOne, bookInfoTwo, "具有相同属性的BookInfo对象应该相等");

        // 不同的BookInfo对象
        BookInfo bookInfoThree = new BookInfo("Clean Code", "Robert C. Martin", "123");
        assertNotEquals(bookInfoOne, bookInfoThree, "具有不同属性的BookInfo对象不应该相等");
    }
}
