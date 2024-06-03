package com.example.bookstore.domain.order.entity;

import com.example.bookstore.domain.order.id.OrderItemId;
import com.example.bookstore.domain.order.valueobject.BookInfo;
import com.example.bookstore.domain.order.valueobject.Price;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单项，表示订单中的一种图书及其购买数量和价格。
 * 该实体通过所属订单的ID（orderId）和图书的ISBN（isbn）组合来唯一标识。
 */
@Entity
@IdClass(OrderItemId.class)
public class OrderItem implements Serializable {
    @Id
    private String orderId; // 所属订单的ID
    @Id
    private Integer itemId; // 订单项Id

    @Embedded
    private BookInfo bookInfo; // 图书信息值对象

    private int quantity; // 购买数量

    @Embedded
    private Price price; // 购买价格值对象

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId", insertable = false, updatable = false)
    private Order order;

    public OrderItem() {
    }

    public OrderItem(String orderId, Integer itemId, BookInfo bookInfo, int quantity, Price price) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.bookInfo = bookInfo;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public String getOrderId() {
        return orderId;
    }

    public Integer getItemId() {
        return itemId;
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

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public BigDecimal calculateAmount() {
        return this.getPrice().getAmount().multiply(BigDecimal.valueOf(this.getQuantity()));
    }
}
