package com.example.response;

import com.alibaba.fastjson.JSON;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import lombok.Data;

/**
 * 返回数据类型
 * @author zhanghuanfa  2018-01-29 15:32
 */
@Data
public class ResultData implements Serializable {

    private static final long serialVersionUID = 3914220971340385875L;
    private static Logger logger = LoggerFactory.getLogger(ResultData.class);

    /**
     * 业务状态常量：正常
     */
    public static final int STATUS_NORMAL = 1;
    /**
     * 业务状态常量：异常
     */
    public static final int STATUS_ERROR = 0;
    /**
     * 业务状态
     */
    private int status;
    /**
     * 错误信息
     */
    private String errorMessage;
    /**
     * 错误代码code
     */
    private int errorCode;
    /**
     * 返回数据实体
     */
    private Object body;

    public static ResultData succeed(Object body){
        ResultData resultData = new ResultData();
        resultData.setBody(body);
        resultData.setStatus(ResultData.STATUS_NORMAL);
        return resultData;
    }

    public static ResultData failure(String errorMessage) {
        ResultData resultData = new ResultData();
        resultData.setStatus(ResultData.STATUS_ERROR);
        resultData.setErrorMessage(errorMessage);
        return resultData;
    }

    @Override
    public String toString() {
        return "ResultData{" +
               "status=" + status +
               ", errorMessage='" + errorMessage + '\'' +
               ", errorCode=" + errorCode +
               ", body=" + JSON.toJSONString(body) +
               '}';
    }
}
