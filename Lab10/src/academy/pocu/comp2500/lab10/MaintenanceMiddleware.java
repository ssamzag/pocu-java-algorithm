package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class MaintenanceMiddleware implements IRequestHandler {
    private final IRequestHandler requestStore;
    private final ServiceUnavailableResult service;
    private static final long MAINTENANCE_HOURS = 1;

    public MaintenanceMiddleware(IRequestHandler store, OffsetDateTime startTime) {
        this.requestStore = store;

        this.service = new ServiceUnavailableResult(startTime, startTime.plusHours(MAINTENANCE_HOURS));
    }

    @Override
    public ResultBase handle(Request request) {
        ResultBase result = requestStore.handle(request);

        if (result.getCode() ==ResultCode.OK) {
            var now = OffsetDateTime.now(ZoneOffset.UTC);
            if (service.getStartTime().isAfter(now) && service.getEndTime().isBefore(now)) {
                return service;
            }
        }

        return result;

    }
}
