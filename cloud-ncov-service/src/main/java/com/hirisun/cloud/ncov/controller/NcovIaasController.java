package com.hirisun.cloud.ncov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hirisun.cloud.common.vo.QueryResponseResult;
import com.hirisun.cloud.model.ncov.vo.iaas.NcovHomePageIaasVo;
import com.hirisun.cloud.ncov.service.NcovIaasService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("基础设施服务（IAAS）")
@RestController
@RequestMapping("/ncov/iaas")
public class NcovIaasController {

	@Autowired
	private NcovIaasService ncovIaasService;
	
    @ApiOperation("虚拟机")
    @ApiResponses(//相应参数说明
            @ApiResponse(code=200,message="success",response= NcovHomePageIaasVo.class)
    )
    @GetMapping(value = "/vm")
    public QueryResponseResult overview(){
        return QueryResponseResult.success(ncovIaasService.getIaasVmData());
    }

    
    /**
     * 疫情云桌面表格数据总览
     *
     * @return
     * @throws Exception 
     */
    @ApiOperation("桌面云")
    @ApiResponses(//响应参数说明
            @ApiResponse(code=200,message="success",response= NcovHomePageIaasVo.class)
    )
    @GetMapping("/desktop")
    @ResponseBody
    public QueryResponseResult epidemicDesktopNum() throws Exception {
    	NcovHomePageIaasVo epidemicDesktopNum = ncovIaasService.epidemicDesktopNum();
    	return QueryResponseResult.success(epidemicDesktopNum);
    }

}