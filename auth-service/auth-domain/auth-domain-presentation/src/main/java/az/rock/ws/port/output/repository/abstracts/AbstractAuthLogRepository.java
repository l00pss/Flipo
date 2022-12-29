package az.rock.ws.port.output.repository.abstracts;

import az.rock.ws.aggregate.AuthLogRoot;

public interface AbstractAuthLogRepository {
    AuthLogRoot createLog(AuthLogRoot root);
}
