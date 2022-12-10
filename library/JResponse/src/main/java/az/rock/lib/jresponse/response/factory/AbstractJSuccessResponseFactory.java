package az.rock.lib.jresponse.response.factory;

import az.rock.lib.jresponse.JHeader;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;

public interface AbstractJSuccessResponseFactory<D> {
    JSuccessResponse factoryResponse();

    JSuccessResponse factoryResponse(String message);

    JSuccessDataResponse<D> factoryResponse(D data);

    JSuccessDataResponse<D> factoryResponse(JHeader header, D data);

    JSuccessDataResponse<D> factoryResponse(D data, String message);

    JSuccessDataResponse<D> factoryResponse(JHeader header, D data, String message);
}
