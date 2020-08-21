package com.hirisun.cloud.order.service.paas;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hirisun.cloud.order.bean.paas.PaasSecurityLogAuit;
import com.hirisun.cloud.order.continer.IApplicationHandler;

/**
 * 大数据安全体系-综合日志审计 服务类
 */
public interface IPaasSecurityLogAuitService extends IService<PaasSecurityLogAuit>,
	IApplicationHandler<PaasSecurityLogAuit> {

}
