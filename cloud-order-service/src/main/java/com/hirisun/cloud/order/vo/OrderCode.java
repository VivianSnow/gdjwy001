package com.hirisun.cloud.order.vo;

import com.hirisun.cloud.common.vo.ResultCode;

public enum OrderCode implements ResultCode {
    CART_CAN_NOT_NULL(2500,"购物车不能为空!"),
    DRAFT_CAN_NOT_COMMIT(2501,"草稿不能提交!"),
    WORKFLOW_INSTANSE_MISSING(2502,"流程实例未找到!"),
    WORKFLOW_ACTIVITY_MISSING(2503,"未找到对应的流程活动信息!"),
    WORKFLOW_MISSING(2504,"流程未找到!"),
    CREATE_ORDER_NUMER_ERROR(2505,"申请单号生成错误,请重试!"),
    ;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 状态信息
     */
    private String msg;

    OrderCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer code() {
        return this.code;
    }

    @Override
    public String msg() {
        return this.msg;
    }
}