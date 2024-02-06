package valueobject;

import java.util.Objects;

/**
 * 图书信息，作为值对象使用，表示订单项中的图书详情。
 */
public class BookInfo {
    private final String isbn;
    private final String title;
    private final String author;

    public BookInfo(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // BookInfo的equals和hashCode方法根据isbn, title, author来实现，确保值对象的等价性

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookInfo bookInfo = (BookInfo) o;
        return isbn.equals(bookInfo.isbn) &&
                title.equals(bookInfo.title) &&
                author.equals(bookInfo.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author);
    }
}
