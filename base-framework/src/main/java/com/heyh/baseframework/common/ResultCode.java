package com.heyh.baseframework.common;

/**
 * @author hos
 * @Createdate 2022/3/19 10:43
 */
public class ResultCode {

    private String message;
    private int code;

    private ResultCode() {
    }

    private ResultCode(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public static final ResultCode RESULT_CODE_SUCCESS = new ResultCode(200, "success");
    public static final ResultCode RESULT_CODE_FAIL = new ResultCode(400, "fail");

    public static final ResultCode RESULT_CODE_FAIL_SERVER = new ResultCode(400, "server fail");
}
