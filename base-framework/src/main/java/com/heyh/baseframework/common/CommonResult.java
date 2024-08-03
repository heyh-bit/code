package com.heyh.baseframework.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author hos
 * @Createdate 2022/3/19 10:37
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "返回结果实体类", description = "结果实体类")
public class CommonResult<T> implements Serializable {

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    //响应码
    @ApiModelProperty(value = "响应码", required = true)
    private int code;

    //返回消息体
    @ApiModelProperty(value = "响应数据", required = true)
    private T body;

    //返回消息信息
    @ApiModelProperty(value = "响应消息", required = true)
    private String message;

    /**
     * 构造器
     *
     * @param body 响应数据
     */
    public CommonResult(T body) {
        this.body = body;
    }

    /**
     * 构造器
     *
     * @param body    响应数据
     * @param message 响应消息
     */
    public CommonResult(T body, String message) {
        this.body = body;
        this.message = message;
    }

    /**
     * 构造器
     *
     * @param code    响应码
     * @param body    响应数据
     * @param message 响应消息
     */
    public CommonResult(int code, T body, String message) {
        this.code = code;
        this.body = body;
        this.message = message;
    }

    /**
     * 成功响应
     *
     * @param <T> 响应数据泛型
     * @return 响应体
     */
    public static <T> CommonResult success() {
        return success(ResultCode.RESULT_CODE_SUCCESS.getCode(), null, ResultCode.RESULT_CODE_SUCCESS.getMessage());
    }

    /**
     * 成功响应
     *
     * @param body 响应数据
     * @param <T>  响应数据泛型
     * @return 响应体
     */
    public static <T> CommonResult success(T body) {
        return success(ResultCode.RESULT_CODE_SUCCESS.getCode(), body, ResultCode.RESULT_CODE_SUCCESS.getMessage());
    }

    /**
     * 成功响应
     *
     * @param body    响应数据
     * @param message 响应消息
     * @param <T>     响应数据泛型
     * @return 响应体
     */
    public static <T> CommonResult success(T body, String message) {
        return success(ResultCode.RESULT_CODE_SUCCESS.getCode(), body, message);
    }

    /**
     * 成功响应
     *
     * @param code    响应码
     * @param body    响应数据
     * @param message 响应消息
     * @param <T>     响应数据泛型
     * @return 响应体
     */
    public static <T> CommonResult success(int code, T body, String message) {
        return new CommonResult(code, body, message);
    }

    /**
     * 失败响应
     *
     * @param <T> 响应数据泛型
     * @return 响应体
     */
    public static <T> CommonResult fail() {
        return fail(ResultCode.RESULT_CODE_FAIL.getCode(), null, ResultCode.RESULT_CODE_SUCCESS.getMessage());
    }

    /**
     * 失败响应
     *
     * @param body 响应数据
     * @param <T>  响应数据泛型
     * @return 响应体
     */
    public static <T> CommonResult fail(T body) {
        return fail(ResultCode.RESULT_CODE_FAIL.getCode(), body, ResultCode.RESULT_CODE_SUCCESS.getMessage());
    }

    /**
     * 失败响应
     *
     * @param body    响应数据
     * @param message 响应消息
     * @param <T>     响应数据泛型
     * @return 响应体
     */
    public static <T> CommonResult fail(T body, String message) {
        return fail(ResultCode.RESULT_CODE_FAIL.getCode(), body, message);
    }

    /**
     * 失败响应
     *
     * @param code    响应码
     * @param body    响应数据
     * @param message 响应消息
     * @param <T>     响应数据泛型
     * @return
     */
    public static <T> CommonResult fail(int code, T body, String message) {
        return new CommonResult(code, body, message);
    }
}
