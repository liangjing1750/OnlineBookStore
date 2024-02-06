package entity;

import valueobject.BookInfo;
import valueobject.Price;

/**
 * 订单项，表示订单中的一种图书及其购买数量和价格。
 * 该实体通过所属订单的ID（orderId）和图书的ISBN（isbn）组合来唯一标识。
 */
public class OrderItem {
    private String orderId; // 所属订单的ID
    private String isbn; // 图书的ISBN
    private BookInfo bookInfo; // 图书信息值对象
    private int quantity; // 购买数量
    private Price price; // 购买价格值对象

    public OrderItem(String orderId, String isbn, BookInfo bookInfo, int quantity, Price price) {
        this.orderId = orderId;
        this.isbn = isbn;
        this.bookInfo = bookInfo;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public String getOrderId() {
        return orderId;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public int getQuantity() {
        return quantity;
    }

    public Price getPrice() {
        return price;
    }
}
