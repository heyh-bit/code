package com.heyh.baseframework.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * wechat-information-platform BaseResponse
 *
 * @param <T> 数据泛型
 * @param <V> 扩展泛型
 * @author hyf
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "网关公共响应", description = "网关公共响应")
public class BaseResponse<T, V> implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 5694178244434983673L;

    /**
     * 是否成功
     */
    @ApiModelProperty(value = "是否成功", required = true)
    private Boolean success;
    /**
     * 异常编码
     */
    @ApiModelProperty("异常编码")
    private String code;
    /**
     * 响应消息
     */
    @ApiModelProperty("响应消息")
    private String message;
    /**
     * 响应数据
     */
    @ApiModelProperty("响应数据")
    private T data;
    /**
     * 扩展信息
     */
    @ApiModelProperty("扩展信息")
    private V extend;

    /**
     * 构造器
     *
     * @param success 是否成功
     * @param code    异常编码
     * @param message 响应消息
     */
    public BaseResponse(Boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    /**
     * 构造器
     *
     * @param success 是否成功
     * @param code    异常编码
     * @param message 响应消息
     * @param data    响应数据
     * @param extend  扩展信息
     */
    public BaseResponse(Boolean success, String code, String message, T data, V extend) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        this.extend = extend;
    }

    /**
     * 初始化
     *
     * @return 响应体
     */
    public BaseResponse<T, V> init() {
        this.success = this.success == null ? false : this.success;
        return this;
    }

    /**
     * 成功响应
     *
     * @param data 响应数据
     * @param <T>  响应数据泛型
     * @param <V>  扩展信息泛型
     * @return 响应体
     */
    public static <T, V> BaseResponse<T, V> success(T data) {
        return new BaseResponse<T, V>(true, null, null, data, null);
    }

    /**
     * 成功响应
     *
     * @param data   响应数据
     * @param extend 扩展信息
     * @param <T>    响应数据泛型
     * @param <V>    扩展信息泛型
     * @return 响应体
     */
    public static <T, V> BaseResponse<T, V> success(T data, V extend) {
        return new BaseResponse<T, V>(true, null, null, data, extend);
    }

    /**
     * 成功响应
     *
     * @param message 响应消息
     * @param data    响应数据
     * @param extend  扩展信息
     * @param <T>     响应数据泛型
     * @param <V>     扩展信息泛型
     * @return 响应体
     */
    public static <T, V> BaseResponse<T, V> success(String message, T data, V extend) {
        return new BaseResponse<T, V>(true, null, message, data, extend);
    }

    /**
     * 失败响应
     *
     * @param code 异常编码
     * @param <T>  响应数据泛型
     * @param <V>  扩展信息泛型
     * @return 响应体
     */
    public static <T, V> BaseResponse<T, V> fail(String code) {
        return new BaseResponse<T, V>(false, code, code, null, null);
    }

    /**
     * 失败响应
     *
     * @param <T>    响应数据泛型
     * @param <V>    扩展信息泛型
     * @param code   异常编码
     * @param extend 扩展信息
     * @return 响应体
     */
    public static <T, V> BaseResponse<T, V> failEx(String code, V extend) {
        return new BaseResponse<T, V>(false, code, code, null, extend);
    }

    /**
     * 失败响应
     *
     * @param code    异常编码
     * @param message 响应消息
     * @param <T>     响应数据泛型
     * @param <V>     扩展信息泛型
     * @return 响应体
     */
    public static <T, V> BaseResponse<T, V> fail(String code, String message) {
        return new BaseResponse<T, V>(false, code, message, null, null);
    }

    /**
     * 失败响应
     *
     * @param <T>     响应数据泛型
     * @param <V>     扩展信息泛型
     * @param code    异常编码
     * @param message 响应消息
     * @param extend  扩展信息
     * @return 响应体
     */
    public static <T, V> BaseResponse<T, V> failEx(String code, String message, V extend) {
        return new BaseResponse<T, V>(false, code, message, null, extend);
    }
}
