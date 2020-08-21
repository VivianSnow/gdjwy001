package com.hirisun.cloud.order.service.paas;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hirisun.cloud.order.bean.paas.PaasDcs;
import com.hirisun.cloud.order.continer.IApplicationHandler;

/**
 * 基于虚拟机的DCS分布式缓存 服务类
 */
public interface IPaasDcsService extends IService<PaasDcs>,IApplicationHandler<PaasDcs>{

}