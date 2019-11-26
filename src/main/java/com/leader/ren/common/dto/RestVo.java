package com.leader.ren.common.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.leader.ren.common.constant.RestMsg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Date;

@Data
@ApiModel(value = "业务响应实体")
public class RestVo<T> implements Serializable {

    private static final long serialVersionUID = -5668554152671000203L;

    /**
     * 应用返回编码
     */
    @ApiModelProperty(value = "应用返回编码", name = "appCode")
    private String appCode;

    /**
     * 应用返回消息
     */
    @ApiModelProperty(value = "应用返回消息", name = "appMsg")
    private String appMsg;

    /**
     * 应用返回结果
     */
    @ApiModelProperty(value = "应用返回结果", name = "result")
    private T result;

    @ApiModelProperty(value = "应用返回结果", name = "success")
    private boolean success = true;

    @ApiModelProperty(value = "服务器时间", name = "now")
    private Date now = new Date();

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    public Date getNowNumber() {
        return now;
    }

    public RestVo() {
        RestMsg result = RestMsg.SUCCESS;
        this.appCode = result.getCode();
        this.appMsg = result.getName();
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
        if (StringUtils.isBlank(this.appCode) || !RestMsg.SUCCESS.getCode().equals(this.appCode)) {
            this.success = false;
        }
    }

    public void setAppCode(RestMsg result) {
        this.appCode = result.getCode();
        this.appMsg = result.getName();
        if (StringUtils.isBlank(this.appCode) || !RestMsg.SUCCESS.getCode().equals(this.appCode)) {
            this.success = false;
        }
    }

    public String getAppMesg() {
        return appMsg;
    }

    public void setAppMesg(String appMesg) {
        this.appMsg = appMesg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }


    public static RestVo SUCCESS() {
        RestVo<Object> restVo = new RestVo<>();
        RestMsg result = RestMsg.SUCCESS;
        restVo.setAppCode(result.getCode());
        restVo.setAppMesg(result.getName());
        return restVo;
    }

    public static RestVo SUCCESS(Object obj) {
        RestVo<Object> restVo = new RestVo<>();
        RestMsg result = RestMsg.SUCCESS;
        restVo.setAppCode(result.getCode());
        restVo.setAppMesg(result.getName());
        restVo.setResult(obj);
        return restVo;
    }

    public static RestVo SUCCESS(Object obj, String msg) {
        RestVo<Object> restVo = new RestVo<>();
        RestMsg result = RestMsg.SUCCESS;
        restVo.setAppCode(result.getCode());
        restVo.setAppMesg(msg);
        restVo.setResult(obj);
        return restVo;
    }


    public static RestVo FAIL() {
        RestVo<Object> restVo = new RestVo<>();
        RestMsg result = RestMsg.FAIL;
        restVo.setAppCode(result.getCode());
        restVo.setAppMesg(result.getName());
        restVo.setSuccess(false);
        return restVo;
    }

    public static RestVo FAIL(String msg) {
        RestVo<Object> restVo = new RestVo<>();
        RestMsg result = RestMsg.FAIL;
        restVo.setAppCode(result.getCode());
        restVo.setAppMesg(msg);
        restVo.setSuccess(false);
        return restVo;
    }


    public static RestVo FAIL(RestMsg result) {
        RestVo<Object> restVo = new RestVo<>();
        restVo.setAppCode(result.getCode());
        restVo.setAppMesg(result.getName());
        restVo.setSuccess(false);
        return restVo;
    }

    public static RestVo ERROR() {
        RestVo<Object> restVo = new RestVo<>();
        restVo.setAppCode(RestMsg.ERROR);
        return restVo;
    }

    public static RestVo FAIL(String code, String msg) {
        RestVo<Object> restVo = new RestVo<>();
        restVo.setAppCode(code);
        restVo.setAppMesg(msg);
        restVo.setSuccess(false);
        return restVo;
    }

    public static RestVo FAIL(RestMsg result, String msg) {
        RestVo<Object> restVo = new RestVo<>();
        restVo.setAppCode(result.getCode());
        restVo.setAppMesg(msg);
        restVo.setSuccess(false);
        return restVo;
    }

    public static RestVo FAIL(Object obj, String code, String msg) {
        RestVo<Object> restVo = new RestVo<>();
        restVo.setAppCode(code);
        restVo.setAppMesg(msg);
        restVo.setResult(obj);
        restVo.setSuccess(false);
        return restVo;
    }

    public static RestVo FAIL(Object obj, String msg) {
        RestVo<Object> restVo = new RestVo<>();
        RestMsg result = RestMsg.FAIL;
        restVo.setAppCode(result.getCode());
        restVo.setAppMesg(msg);
        restVo.setResult(obj);
        restVo.setSuccess(false);
        return restVo;
    }

    /**
     * 用于替换参数的形式
     *
     * @param result
     * @param arguments 替换参数，可多个 {%s},{%s}...
     * @return cn.com.waterelephant.wenewrs.domain.common.vo.RestVo
     * @author 施冬冬
     * date:  2019/4/28 13:37
     */
    public static RestVo FAIL(RestMsg result, Object... arguments) {
        RestVo<Object> restVo = new RestVo<>();
        restVo.setAppCode(result.getCode());
        restVo.setAppMesg(MessageFormat.format(result.getName(), arguments));
        restVo.setSuccess(false);
        return restVo;
    }

    /**
     * 如果接口对象不为空并且返回码为成功(SUCCESS.getCode()), 返回true，否则返回false
     *
     * @param restVo
     * @return
     * @author: 兰祥建
     * date 2018/12/27 18:23
     */
    public static boolean checkSuccessCode(RestVo restVo) {
        return restVo != null && RestMsg.SUCCESS.getCode().equals(restVo.getAppCode());
    }

    public boolean isSuccess() {
        return success;
    }
}
