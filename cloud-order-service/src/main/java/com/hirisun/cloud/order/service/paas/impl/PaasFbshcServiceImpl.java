package com.hirisun.cloud.order.service.paas.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hirisun.cloud.order.bean.application.ApplicationInfo;
import com.hirisun.cloud.order.bean.paas.PaasFbshc;
import com.hirisun.cloud.order.bean.shopping.ShoppingCart;
import com.hirisun.cloud.order.mapper.paas.PaasFbshcMapper;
import com.hirisun.cloud.order.service.paas.IPaasFbshcService;

/**
 * PaaS 分布式缓存申请信息 服务实现类
 */
@Service
public class PaasFbshcServiceImpl extends ServiceImpl<PaasFbshcMapper, PaasFbshc> implements IPaasFbshcService {

    @Override
    public void saveShoppingCart(ShoppingCart<PaasFbshc> shoppingCart) {
        List<PaasFbshc> serverList = shoppingCart.getServerList();
        if (serverList != null && !serverList.isEmpty()) {
            for (PaasFbshc txyfw : serverList) {
                txyfw.setId(null);
                txyfw.setShoppingCartId(shoppingCart.getId());
                this.save(txyfw);
            }
        }
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void save(ApplicationInfo<PaasFbshc, Object> info) {
        List<PaasFbshc> serverList = info.getServerList();
        if (serverList != null && !serverList.isEmpty()) {
            for (PaasFbshc txyfw : serverList) {
                txyfw.setId(null);
                txyfw.setAppInfoId(info.getId());
                this.save(txyfw);
            }
        }
    }

    @Override
    public List<PaasFbshc> getByAppInfoId(String appInfoId) {
        return this.list(new QueryWrapper<PaasFbshc>().lambda()
                .eq(PaasFbshc::getAppInfoId, appInfoId)
                .orderByAsc(PaasFbshc::getCreateTime));
    }

    @Override
    public List<PaasFbshc> getByShoppingCartId(String shoppingCartId) {
        return this.list(new QueryWrapper<PaasFbshc>().lambda()
                .eq(PaasFbshc::getShoppingCartId, shoppingCartId)
                .orderByAsc(PaasFbshc::getCreateTime));
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void update(ApplicationInfo<PaasFbshc, Object> info) {
        this.remove(new QueryWrapper<PaasFbshc>().lambda().eq(PaasFbshc::getAppInfoId, info.getId()));

        save(info);
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void updateShoppingCart(ShoppingCart<PaasFbshc> shoppingCart) {
        this.remove(new QueryWrapper<PaasFbshc>().lambda().eq(PaasFbshc::getShoppingCartId, shoppingCart.getId()));

        saveShoppingCart(shoppingCart);
    }

    @Override
    public Integer getTotalNum(String appInfoId) {
        return 1;
    }

    @Override
    public Integer getTotalNumInShoppingCart(String shoppingCartId) {
        return 1;
    }

    /**
     * 购物车删除
     *
     * @param shoppingCartId 购物车ID
     */
    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void deleteByShoppingCart(String shoppingCartId) {
        this.remove(new QueryWrapper<PaasFbshc>().lambda().eq(PaasFbshc::getShoppingCartId, shoppingCartId));
    }

    /**
     * 服务关联订单
     *
     * @param shoppingCartId
     * @param appInfoId
     */
    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void refAppInfoFromShoppingCart(String shoppingCartId, String appInfoId) {
        this.update(new PaasFbshc(),new UpdateWrapper<PaasFbshc>().lambda().eq(PaasFbshc::getShoppingCartId,shoppingCartId)
                .set(PaasFbshc::getAppInfoId,appInfoId));
    }

}
