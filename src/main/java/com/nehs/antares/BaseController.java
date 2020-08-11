package com.nehs.antares;

import com.nehs.antares.bo.JsonResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有controller类的基类，负责校验和返回统一结果对象
 * <p>
 * 调用成功用"succeeded"，失败调用"failed"
 */
public abstract class BaseController {

    /**
     * 返回封装好的结果   成功
     *
     * @return
     */
    public JsonResponse succeed() {
        return succeed(null);
    }

    /**
     * 返回封装好的结果   成功
     *
     * @param object
     * @return
     */
    public JsonResponse succeed(Object object) {
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setFlag(true);
        jsonResponse.setReturnObject(object);
        return jsonResponse;
    }

    /**
     * 返回封装好的结果 失败
     *
     * @param failedMsg
     * @return
     */
    public JsonResponse failed(String failedMsg) {
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setFlag(false);
        List<String> MsgList = new ArrayList<>(4);
        jsonResponse.setErrors(MsgList);
        return jsonResponse;
    }

    /**
     * 失败后，将错误码和错误信息封装返回
     * @param returnCode
     * @param returnMsg
     * @return
     */
    public JsonResponse failed(long returnCode,String returnMsg){
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setFlag(false);
        jsonResponse.setReturnCode(returnCode);
        jsonResponse.setReturnMsg(returnMsg);
        return jsonResponse;
    }

}
