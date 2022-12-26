package az.rock.ws.config.security.filter;

public class JFilterConfig<T extends JFilter>{
    private final JFilter filter;
    public JFilterConfig(JFilter filter){
        this.filter = filter;
    }


}
