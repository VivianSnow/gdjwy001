package com.hirisun.cloud.order.service.paas;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hirisun.cloud.order.bean.paas.PaasTyyh;
import com.hirisun.cloud.order.continer.IApplicationHandler;

/**
 * 统一消息申请信息 服务类
 */
public interface IPaasTyyhService extends IService<PaasTyyh>, IApplicationHandler<PaasTyyh> {

}