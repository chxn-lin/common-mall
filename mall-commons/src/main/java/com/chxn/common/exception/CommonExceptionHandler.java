package com.chxn.common.exception;

import com.chxn.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice(basePackages = "com.chxn.mall.product.controller")
public class CommonExceptionHandler {

    /**
     * 校验异常
     * @param e
     * @return
     */
    @ExceptionHandler
    public R validExceptionHandler(MethodArgumentNotValidException e){
        Map<String,String> map = new HashMap<>();
        e.getFieldErrors().forEach((fieldError)->{
            map.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return R.error(400,"提交的数据不合法").put("data",map);
    }

    /**
     * 系统其他的异常处理
     * @param throwable
     * @return
     */
    @ExceptionHandler(Throwable.class)
    public R handlerExecption(Throwable throwable){
        log.error("错误信息：",throwable);
        return R.error(400,"未知异常信息").put("data",throwable.getMessage());
    }

}
