package az.rock.lib.value.generic;

import az.rock.lib.value.annotation.ValueObject;

@ValueObject
public class JContact {

    private final JContactType contactType ;

    private final JContactLiveType contactLiveType ;

    private final String contact;


    public JContact(JContactType contactType, JContactLiveType contactLiveType, String contact) {
        this.contactType = contactType;
        this.contactLiveType = contactLiveType;
        this.contact = contact;
    }
}
