package com.hirisun.cloud.third.util.easypoi;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.hirisun.cloud.model.ncov.vo.daas.NcovExcelSheetOneVo;
import com.hirisun.cloud.model.ncov.vo.daas.NcovExcelSheetTwoVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * @author wuc
 * @date 2020/2/19
 */
@Component
public class NcovExcelImportUtil {

    private final static  String sourceFileName = "ncovSource.xlsx";

    private static String rootPath;

    @Value("${file.path}")
    public void setRootPath(String rootPath) {
        NcovExcelImportUtil.rootPath = rootPath;
    }

    public  static  List<NcovExcelSheetOneVo>  getSheetOneData(){
        try{
            ImportParams params = new ImportParams();
            params.setStartSheetIndex(0);
            List<NcovExcelSheetOneVo> list = ExcelImportUtil.importExcel(new FileInputStream(new File(rootPath+"/"+sourceFileName)),NcovExcelSheetOneVo.class,params);
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public static  List<NcovExcelSheetTwoVo> getSheetTwoData(){
        try{
            ImportParams params = new ImportParams();
            params.setStartSheetIndex(1);
            List<NcovExcelSheetTwoVo> list = ExcelImportUtil.importExcel(new FileInputStream(new File(rootPath+"/"+sourceFileName)),NcovExcelSheetTwoVo.class,params);
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        NcovExcelImportUtil.getSheetTwoData();
    }

}