package com.bonjourcs.java.common.bean;

/**
 * @author Liang Chenghao
 * Description: common return object
 * Date: 2018/4/9
 */
public class RetObject<T> {

    /**
     * success code
     */
    private static final String CODE_SUCCESS = "000000";
    /**
     * failure code
     */
    private static final String CODE_FAILURE = "999999";
    /**
     * return code
     */
    private String retCode;
    /**
     * secondary return code
     */
    private String retSubCode;
    /**
     * success status
     */
    private boolean success;
    /**
     * return message
     */
    private String retMsg;
    /**
     * payload
     */
    private T retData;

    public RetObject() {
    }

    public static <T> RetObject<T> success() {
        RetObject<T> retObject = new RetObject<>();
        retObject.retCode = CODE_SUCCESS;
        return retObject;
    }

    public static <T> RetObject<T> fail() {
        RetObject<T> retObject = new RetObject<>();
        retObject.retCode = CODE_FAILURE;
        return retObject;
    }

    public String getRetCode() {
        return retCode;
    }

    public String getRetSubCode() {
        return retSubCode;
    }

    public boolean isSuccess() {
        return CODE_SUCCESS.equals(getRetCode());
    }

    public String getRetMsg() {
        return retMsg;
    }

    public T getRetData() {
        return retData;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public void setRetSubCode(String retSubCode) {
        this.retSubCode = retSubCode;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public void setRetData(T retData) {
        this.retData = retData;
    }

}
