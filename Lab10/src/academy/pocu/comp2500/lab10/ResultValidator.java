package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class ResultValidator {
    private ResultBase resultBase;

    public ResultValidator(ResultBase resultBase) {
        this.resultBase = resultBase;
    }

    public Boolean isValid(ResultCode resultCode) {
        return resultBase.getCode() == resultCode &&
                (resultBase instanceof OkResult && resultBase.getCode() == ResultCode.OK
                        || resultBase instanceof NotFoundResult && resultBase.getCode() == ResultCode.NOT_FOUND
                        || resultBase instanceof CachedResult && resultBase.getCode() == ResultCode.NOT_MODIFIED
                        || resultBase instanceof ServiceUnavailableResult && resultBase.getCode() == ResultCode.SERVICE_UNAVAILABLE
                        || resultBase instanceof UnauthorizedResult && resultBase.getCode() == ResultCode.UNAUTHORIZED);
    }
}
