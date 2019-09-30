package com.fgrapp.blog.blogserver.common.exception;

import com.fgrapp.blog.blogserver.common.exception.enums.ErrorEnum;
import lombok.Data;

/**
 * 自定义异常
 *
 * @author FGR on 2019/9/26
 */
@Data
public class MyException extends RuntimeException{
    private String msg;
    private int code = 500;

    public MyException(){
        super(ErrorEnum.UNKNOWN.getMsg());
        this.msg=ErrorEnum.UNKNOWN.getMsg();
    }




    public MyException(ErrorEnum eEnum,Throwable e){
        super(eEnum.getMsg(),e);
        this.msg=eEnum.getMsg();
        this.code=eEnum.getCode();
    }

    public MyException(ErrorEnum eEnum){
        this.msg=eEnum.getMsg();
        this.code=eEnum.getCode();
    }

    public MyException(String exception){
        this.msg=exception;
    }

}
