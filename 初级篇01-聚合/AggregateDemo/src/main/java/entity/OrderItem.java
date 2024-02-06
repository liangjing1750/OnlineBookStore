package entity;

/**
 * OrderItem类表示订单中的单个项目，包括图书的ISBN、标题、作者和数量。
 */
public class OrderItem {

    // orderid+isbn作为唯一标识
    private String orderId;
    private String isbn;

    private String title;
    private String author;
    private int quantity;

    public OrderItem(String orderId, String isbn, String title, String author, int quantity) {
        this.orderId = orderId;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    // Getter 和 Setter 方法
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }
}
