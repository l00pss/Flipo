package az.rock.lib.value.generic;

import az.rock.lib.value.annotation.ValueObject;

import java.math.BigDecimal;


@ValueObject
public class JGeoPosition {

    private final BigDecimal lat;

    private final BigDecimal lng;


    public JGeoPosition(BigDecimal lat, BigDecimal lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
