package az.rock.lib.request.factory;

import az.rock.lib.JHeader;
import az.rock.lib.request.JRequest;

public class JRequestFactory<D> implements AbstractJRequestFactory<D>{
    @Override
    public JRequest<D> factory(D data) {
        return new JRequest<>(data);
    }

    @Override
    public JRequest<D> factory(JHeader header, D data) {
        return new JRequest<>(header, data);
    }
}
