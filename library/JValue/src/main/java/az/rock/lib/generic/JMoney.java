package az.rock.lib.generic;
import az.rock.lib.annotation.ValueObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@ValueObject
public final class JMoney {

    private final BigDecimal amount;

    public static final JMoney ZERO = new JMoney(BigDecimal.ZERO);

    public JMoney(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isGreaterThanZero() {
        return this.amount != null && this.amount.compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean isGreaterThan(JMoney money) {
        return this.amount != null && this.amount.compareTo(money.getAmount()) > 0;
    }

    public JMoney add(JMoney money) {
        return new JMoney(setScale(this.amount.add(money.getAmount())));
    }

    public JMoney subtract(JMoney money) {
        return new JMoney(setScale(this.amount.subtract(money.getAmount())));
    }

    public JMoney multiply(int multiplier) {
        return new JMoney(setScale(this.amount.multiply(new BigDecimal(multiplier))));
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JMoney money = (JMoney) o;
        return amount.equals(money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    private BigDecimal setScale(BigDecimal input) {
        return input.setScale(2, RoundingMode.HALF_EVEN);
    }
}