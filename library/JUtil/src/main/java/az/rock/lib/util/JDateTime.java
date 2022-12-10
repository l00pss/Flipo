package az.rock.lib.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public enum JDateTime {
    UTC{
        @Override
        public ZonedDateTime now() {
            return ZonedDateTime.now(ZoneId.of("UTC"));
        }
    };

    public abstract ZonedDateTime now();
}
