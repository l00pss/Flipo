package az.rock.lib.request.factory;

import az.rock.lib.JHeader;
import az.rock.lib.request.JRequest;

public interface AbstractJRequestFactory<D> {
    JRequest<D> factory(D data);
    JRequest<D> factory(JHeader header, D data);
}
