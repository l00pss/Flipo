package az.rock.lib.generic;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public class JAccountPacket {

    public final static JAccountPacket NON_PREMIUM_ACCOUNT = new JAccountPacket();

    private final Boolean isPremium;

    public JAccountPacket(){
        this.isPremium = Boolean.FALSE;
    }

    public JAccountPacket(Boolean isPremium){
        this.isPremium = isPremium;
    }

    public Boolean isPremium() {
        return isPremium;
    }
}
