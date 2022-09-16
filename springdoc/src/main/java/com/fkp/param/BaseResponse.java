package com.fkp.param;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(description = "返回响应数据")
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 2621638727631497840L;
    @Schema(description = "错误码")
    private String code;
    @Schema(description = "响应状态")
    private String status;
    @Schema(description = "响应信息")
    private String msg;
    @Schema(description = "响应数据")
    private T data;
    private static final String CODE_SUCCESS = "000000";
    private static final String STATUS_SUCCESS = "success";
    private static final String STATUS_FAIL = "fail";
    private static final String MESSAGE_SUCCESS = "operation success";

    public BaseResponse() {
    }

    public BaseResponse(String code, String status, String msg) {
        this.code = code;
        this.status = status;
        this.msg = msg;
    }

    public BaseResponse(String code, String status, String msg, T data) {
        this.code = code;
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static <T> BaseResponse<T> success(){
        BaseResponse<T> res = new BaseResponse<>();
        res.setCode(CODE_SUCCESS);
        res.setStatus(STATUS_SUCCESS);
        res.setMsg(MESSAGE_SUCCESS);
        return res;
    }
//
//    public static <T> BaseResponse<T> success(String msg){
//        BaseResponse<T> res = new BaseResponse<>();
//        res.setCode(CODE_SUCCESS);
//        res.setStatus(STATUS_SUCCESS);
//        res.setMsg(msg);
//        return res;
//    }

    public static <T> BaseResponse<T> success(T data){
        BaseResponse<T> res = new BaseResponse<>();
        res.setCode(CODE_SUCCESS);
        res.setStatus(STATUS_SUCCESS);
        res.setMsg(MESSAGE_SUCCESS);
        res.setData(data);
        return res;
    }

    public static <T> BaseResponse<T> success(String msg, T data){
        BaseResponse<T> res = new BaseResponse<>();
        res.setCode(CODE_SUCCESS);
        res.setStatus(STATUS_SUCCESS);
        res.setMsg(msg);
        res.setData(data);
        return res;
    }

    public static <T> BaseResponse<T> fail(String code, String msg){
        BaseResponse<T> res = new BaseResponse<>();
        res.setCode(code);
        res.setStatus(STATUS_FAIL);
        res.setMsg(msg);
        return res;
    }

    public static <T> BaseResponse<T> fail(String code, String msg, T data){
        BaseResponse<T> res = new BaseResponse<>();
        res.setCode(code);
        res.setStatus(STATUS_FAIL);
        res.setMsg(msg);
        res.setData(data);
        return res;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
