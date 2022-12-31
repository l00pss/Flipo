package az.rock.ws;

import az.rock.lib.jresponse.response.fail.JFailResponse;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum ServerFailPattern {
    UNAUTHORIZED(401){
        @Override
        public JFailResponse get() {
            return new JFailResponse("Icazə verilməyən istək forması");
        }
    },
    INTERNAL_SERVER_ERROR(500){
        @Override
        public JFailResponse get() {
            return new JFailResponse("Bir sistem xətası çıxdı :( Ən qısa zamanda həll etməyə çalışacağıq");
        }
    },
    SERVICE_UNAVAILABLE(503){
        @Override
        public JFailResponse get() {
            return new JFailResponse("Bir sistem xətası çıxdı :( Ən qısa zamanda həll etməyə çalışacağıq");
        }
    };

    private int status;
    ServerFailPattern(int status) {
        this.status = status;
    }

    public abstract JFailResponse get();

    public static ServerFailPattern find(int status){
        return Arrays.stream(ServerFailPattern.values()).filter(e->e.status == status).findFirst().orElse(ServerFailPattern.INTERNAL_SERVER_ERROR);
    }
}
