package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class ResultValidator {
    private final ResultBase resultBase;

    public ResultValidator(ResultBase resultBase) {
        this.resultBase = resultBase;
    }

    public Boolean isValid(ResultCode resultCode) {
        return resultBase.getCode() == resultCode &&
                (resultBase instanceof OkResult && resultCode == ResultCode.OK
                        || resultBase instanceof NotFoundResult && resultCode == ResultCode.NOT_FOUND
                        || resultBase instanceof CachedResult && resultCode == ResultCode.NOT_MODIFIED
                        || resultBase instanceof ServiceUnavailableResult && resultCode == ResultCode.SERVICE_UNAVAILABLE
                        || resultBase instanceof UnauthorizedResult && resultCode == ResultCode.UNAUTHORIZED);
    }
}
