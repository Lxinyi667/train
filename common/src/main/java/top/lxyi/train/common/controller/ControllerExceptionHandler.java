package top.lxyi.train.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lxyi.train.common.exception.BusinessException;
import top.lxyi.train.common.resp.CommonResp;

@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    //所有异常统一处理
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResp<?> exceptionHandler(Exception e ) throws Exception {
        CommonResp<?> commonResp = new CommonResp<>();
        LOG.error("系统异常：", e);
        commonResp.setSuccess(false);
        commonResp.setMessage(e.getMessage());
        return commonResp;
    }
   //业务异常统一处理
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public CommonResp<?> exceptionHandler(BusinessException e ){
        CommonResp<?> commonResp = new CommonResp<>();
        LOG.error("业务异常：{}", e.getE().getDesc());
        commonResp.setSuccess(false);
        commonResp.setMessage(e.getE().getDesc());
        return commonResp;
    }
    //校验异常统一处理
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public CommonResp<?> exceptionHandler(BindException e ){
        CommonResp<?> commonResp = new CommonResp<>();
        LOG.error("校验异常：",e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        commonResp.setSuccess(false);
        commonResp.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return commonResp;
    }
}
