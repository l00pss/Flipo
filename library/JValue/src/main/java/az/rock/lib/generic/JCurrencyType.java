package az.rock.lib.generic;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public enum JCurrencyType {
    EUR("€"), USD("$"), AZN("₼"), YTL("₺");

    private final String sign;

    JCurrencyType(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
