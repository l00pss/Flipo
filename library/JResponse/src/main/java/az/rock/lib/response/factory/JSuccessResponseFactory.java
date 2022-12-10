package az.rock.lib.response.factory;

import az.rock.lib.JHeader;
import az.rock.lib.response.success.JSuccessDataResponse;
import az.rock.lib.response.success.JSuccessResponse;

public class JSuccessResponseFactory<D> implements AbstractJSuccessResponseFactory<D>{
    @Override
    public JSuccessResponse factoryResponse() {
        return new JSuccessResponse();
    }

    @Override
    public JSuccessResponse factoryResponse(String message) {
        return new JSuccessResponse(message);
    }

    @Override
    public JSuccessDataResponse<D> factoryResponse(D data) {
        return new JSuccessDataResponse<>(data);
    }

    @Override
    public JSuccessDataResponse<D> factoryResponse(JHeader header, D data) {
        return new JSuccessDataResponse<>(header, data);
    }

    @Override
    public JSuccessDataResponse<D> factoryResponse(D data, String message) {
        return new JSuccessDataResponse<>(data, message);
    }

    @Override
    public JSuccessDataResponse<D> factoryResponse(JHeader header, D data, String message) {
        return new JSuccessDataResponse<>(header, data, message);
    }
}
