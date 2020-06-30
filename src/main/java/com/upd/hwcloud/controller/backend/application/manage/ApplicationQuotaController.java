package com.upd.hwcloud.controller.backend.application.manage;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.upd.hwcloud.bean.entity.application.manage.ApplicationQuota;
import com.upd.hwcloud.bean.response.R;
import com.upd.hwcloud.service.application.manage.IApplicationQuotaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lqm
 * @since 2020-06-29
 */
@Api(description = "配额设置")
@RestController
@RequestMapping("/applicationQuota")
public class ApplicationQuotaController {

    @Autowired
    private IApplicationQuotaService applicationQuotaService;

    @ApiOperation(value = "查看单一一个配额信息")
    @RequestMapping(value = "/v1/searchQuota",method = RequestMethod.GET)
    public R getApplicationQuotaById(@RequestParam(value = "id") String id){
        ApplicationQuota applicationQuota = applicationQuotaService.getApplicationQuotaById(id);
        return R.ok(applicationQuota);
    }

    @ApiOperation(value = "新增配额设置")
    @RequestMapping(value = "/v1/addApplicationQuota",method = RequestMethod.POST)
    public R addApplicationQuota(@RequestBody ApplicationQuota applicationQuota){
        applicationQuotaService.addApplicationQuota(applicationQuota);
        return R.ok();
    }

    @ApiOperation(value = "通过申请人查询配额列表")
    @RequestMapping(value = "/v1/searchQuotaByPerson",method = RequestMethod.GET)
    public R searchQuotaByPerson(@RequestParam(value = "applyPerson",required = false) String applyPerson){
        Page<ApplicationQuota> page=new Page<>();
        page.setCurrent(1);
        page.setSize(20);
        Page<ApplicationQuota> applicationQuotaList = applicationQuotaService.getApplicationQuotaList(page, applyPerson);
        return R.ok(applicationQuotaList);
    }

}

