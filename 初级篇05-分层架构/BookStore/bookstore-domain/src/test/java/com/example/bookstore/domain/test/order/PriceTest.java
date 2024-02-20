package com.example.bookstore.domain.test.order;

import com.example.bookstore.domain.order.valueobject.Price;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PriceTest {

    @Test
    public void testPriceImmutability() {
        Price initialPrice = new Price(new BigDecimal("29.99"));

        // 尝试更改Price对象的金额值，预期会抛出异常或无法更改
        assertThrows(UnsupportedOperationException.class, () -> {
            // 假设Price类中有方法可以更改amount的值，这里应该抛出异常
             initialPrice.modify(new BigDecimal("39.99"));
        });

        // 验证金额值未改变
        assertEquals(new BigDecimal("29.99"), initialPrice.getAmount());
    }

    @Test
    public void testPriceEquality() {
        Price priceOne = new Price(new BigDecimal("29.99"));
        Price priceTwo = new Price(new BigDecimal("29.99"));

        // 两个价格相同的Price对象应该被视为等价的
        assertEquals(priceOne, priceTwo, "两个具有相同金额的Price对象应该相等");
    }
}
