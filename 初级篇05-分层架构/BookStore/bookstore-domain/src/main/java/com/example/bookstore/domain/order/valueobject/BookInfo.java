package com.example.bookstore.domain.order.valueobject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * 图书信息，作为值对象使用，表示订单项中的图书详情。
 */
@Embeddable
public class BookInfo implements Serializable {
    private String title;
    private String author;

    public BookInfo() {
    }

    public BookInfo(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // BookInfo的equals和hashCode方法根据isbn, title, author来实现，确保值对象的等价性

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookInfo bookInfo = (BookInfo) o;
        return title.equals(bookInfo.title) &&
                author.equals(bookInfo.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}
