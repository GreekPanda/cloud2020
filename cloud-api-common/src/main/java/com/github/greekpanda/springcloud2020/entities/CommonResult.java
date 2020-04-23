package com.github.greekpanda.springcloud2020.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author greekpanda
 * @create 2020-4-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    //404 nof found
    // 200 success

    private Integer code;
    private String message;
    private T data;

    private CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
