package com.xuecheng.base.execption;

/**
 * 自定义异常
 */
public class XueChengPlusException extends RuntimeException {
    private String errMessage;

    private String errCode;

    public XueChengPlusException() {
    }

    public XueChengPlusException(String errMessage) {
        super(errMessage);
        this.errMessage = errMessage;
    }

    public XueChengPlusException(String errCode, String errMessage) {
        this.errMessage = errMessage;
        this.errCode = errCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public static void cast(CommonError commonError) {
        throw new XueChengPlusException(commonError.getErrMessage());
    }

    public static void cast(String errMessage) {
        throw new XueChengPlusException(errMessage);
    }


}
