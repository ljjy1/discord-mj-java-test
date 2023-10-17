package com.github.dmj.vo;


import lombok.Data;

/**
 * @author xzw
 * @date mailto 741342093@qq.com
 */
@Data
public class Ret<T> {

    private Integer code;
    private String msg;
    private T data;

    private static <T> Ret<T> create(Integer code, String msg, T t) {
        Ret<T> ret = new Ret<>();
        ret.setCode(code);
        ret.setMsg(msg);
        ret.setData(t);
        return ret;
    }

    public static <T> Ret<T> success(T data) {
        return create(0, "成功", data);
    }


    public static <T> Ret<T> failed(Integer code, String msg) {
        return create(code, msg, null);
    }


}
