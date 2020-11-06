package cn.leo.bookkeeping.response;

import cn.leo.bookkeeping.enums.ResponseCode;
import cn.leo.bookkeeping.enums.CommonResponseEnum;

import java.util.Objects;

/**
 * @author leo.zl on 2020/6/1
 */
public class Result<T> {

    /**
     * 快速判断是否成功。responseCode为0000时为成功
     */
    private boolean success;

    /**
     * 响应码
     */
    private String responseCode;

    /**
     * 响应信息
     */
    private String responseMessage;
    /**
     * 结果数据
     */
    private T result;

    private Result(String responseCode, String responseMessage, T result) {
        this.success = Objects.equals(responseCode, CommonResponseEnum.SUCCESS.getResponseCode());
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.result = result;
    }

    private Result() {
    }

    public static <T> Result<T> warpResult(String responseCode, String responseMessage, T result) {
        return new Result<>(responseCode, responseMessage, result);
    }

    public static <T> Result<T> warpResult(String responseCode, String responseMessage) {
        return new Result<>(responseCode, responseMessage, null);
    }

    public static <T> Result<T> warpResult(ResponseCode responseCode, T result) {
        return new Result<>(responseCode.getResponseCode(), responseCode.getResponseMessage(), result);
    }

    public static <T> Result<T> warpResult(ResponseCode responseCode) {
        return warpResult(responseCode, null);
    }


    public boolean isSuccess() {
        return success;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "responseMessage='" + responseCode + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                ", result=" + result +
                '}';
    }

}
