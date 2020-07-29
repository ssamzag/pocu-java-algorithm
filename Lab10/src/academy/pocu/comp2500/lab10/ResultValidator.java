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
        ResultCode baseResultCode = resultBase.getCode();
        return baseResultCode == resultCode
                && (resultBase instanceof OkResult && baseResultCode == ResultCode.OK
                || resultBase instanceof NotFoundResult && baseResultCode == ResultCode.NOT_FOUND
                || resultBase instanceof CachedResult && baseResultCode == ResultCode.NOT_MODIFIED
                || resultBase instanceof ServiceUnavailableResult && baseResultCode == ResultCode.SERVICE_UNAVAILABLE
                || resultBase instanceof UnauthorizedResult && baseResultCode == ResultCode.UNAUTHORIZED);
    }
}
