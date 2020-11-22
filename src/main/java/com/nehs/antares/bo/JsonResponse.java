package com.nehs.antares.bo;

import com.nehs.antares.constant.CommonConstant;
import lombok.Data;

import java.util.List;

/**
 * @author neHs
 */
@Data
public class JsonResponse {

    /**
     * 返回成功/失败
     */
    private boolean flag;
    /**
     * 错误信息
     */
    private List<String> errors;
    /**
     * 返回对象
     */
    private Object returnObject;
    /**
     * 状态码 默认200成功
     */
    private long returnCode = CommonConstant.succeedCode;
    /**
     * 错误信息
     */
    private String returnMsg;
    /**
     * 错误信息参数列表
     */
    private String[] returnMsgArgs;
}
