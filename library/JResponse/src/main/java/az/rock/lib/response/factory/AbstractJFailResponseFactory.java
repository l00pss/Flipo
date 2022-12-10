package az.rock.lib.response.factory;

import az.rock.lib.JHeader;
import az.rock.lib.response.fail.JFailDataResponse;
import az.rock.lib.response.fail.JFailResponse;

public interface AbstractJFailResponseFactory<D> {
    JFailResponse factoryResponse();

    JFailResponse factoryResponse(String message);

    JFailDataResponse<D> factoryResponse(D data);

    JFailDataResponse<D> factoryResponse(JHeader header, D data);

    JFailDataResponse<D> factoryResponse(D data, String message);

    JFailDataResponse<D> factoryResponse(JHeader header, D data, String message);
}
