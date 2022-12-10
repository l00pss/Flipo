package az.rock.lib.generic;

import az.rock.lib.annotation.ValueObject;

import java.math.BigDecimal;

@ValueObject
public class JGeoMapView {
    private final BigDecimal west;
    private final BigDecimal south;
    private final BigDecimal east;
    private final BigDecimal north;

    public JGeoMapView(BigDecimal west, BigDecimal south, BigDecimal east, BigDecimal north) {
        this.west = west;
        this.south = south;
        this.east = east;
        this.north = north;
    }
}
