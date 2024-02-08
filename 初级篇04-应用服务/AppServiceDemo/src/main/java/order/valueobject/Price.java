
package order.valueobject;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 价格，作为值对象使用，表示金额。
 */
public class Price {
    private final BigDecimal amount;

    public Price(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("价格不能为负");
        }
        this.amount = amount;
    }

    // Getter
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        if (amount.compareTo(this.amount) != 0) {
            throw new UnsupportedOperationException("价格不能修改");
        }
    }

    // Price的equals和hashCode方法根据amount来实现，确保值对象的等价性
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return amount.equals(price.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
