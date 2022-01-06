package com.danny.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;
    public CommonResult(Integer code, String message){
        this(code, message, null);
    }
    public CommonResult(){
        this(200, "调用成功", null);
    }
    public static CommonResult<Object> get(){
        return new CommonResult<>(200, "调用成功");
    }

    public CommonResult<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public CommonResult<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public CommonResult<T> setData(T data) {
        this.data = data;
        return this;
    }
}
