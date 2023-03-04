package com.example.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.constant.*;
import com.example.mappers.ToiletMapper;
import com.example.po.Toilet;
import com.example.service.ToiletService;
import com.example.vo.EchDataOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhou
 */
@RestController
@RequestMapping("/api/toilet")
public class ToiletController {


    @Autowired
    ToiletService toiletService;

    //添加或更新
    @RequestMapping(value = "/updateOradd",method = RequestMethod.GET)
    public Result updateOradd(Toilet toilet){
        Result result = new Result();
        try {
            if (toilet.getId()==null){
                toilet.setStatus("无人");
                toilet.setHealth("干净");
                toilet.setUseNum(0);
                toilet.setUseNumCount(0);
            }
            toilet.setType(TpyeEnum.findEnumByName(toilet.getType()));
            toilet.setStatus(StatusEnum.findEnumByName(toilet.getStatus()));
            toilet.setSex(SexEnum.findEnumByName(toilet.getSex()));
            toilet.setPlaceNo(PlaceNoEnum.findEnumByName(toilet.getPlaceNo()));
            toilet.setHealth(HealthEnum.findEnumByName(toilet.getHealth()));
            boolean flag = toiletService.saveOrUpdate(toilet);
            if (flag) { result.setResultCode(ResultCode.SUCCESS);}
        }catch (Exception e){
            e.printStackTrace();
            result.setResultCode(ResultCode.ERROR);
        }
        return result;
    }

    //删除
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Result delete(@RequestParam Integer id){
        Result result = new Result();
        try {
            boolean flag = toiletService.removeById(id);
            if (flag) { result.setResultCode(ResultCode.SUCCESS);}
        }catch (Exception e){
            e.printStackTrace();
            result.setResultCode(ResultCode.ERROR);
        }
        return result;
    }
    
    //分页 条件查询
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public IPage<Toilet> findAll(@RequestParam Integer pageNo,
                                 @RequestParam Integer pageSize,
                                 @RequestParam(defaultValue = "") String type,
                                 @RequestParam(defaultValue = "") String placeNo,
                                 @RequestParam(defaultValue = "") String sex,
                                 @RequestParam boolean status){
        QueryWrapper queryWrapper = new QueryWrapper();
        if (!"".equals(type)){
            queryWrapper.eq("type",type);
        }
        if (!"".equals(placeNo)){
            queryWrapper.eq("place_NO",placeNo);
        }
        if (!"".equals(sex)){
            queryWrapper.eq("sex",sex);
        }
        if (status){
            queryWrapper.eq("status","0");
        }
        IPage<Toilet> page = new Page<>(pageNo,pageSize);
        IPage<Toilet> iPage = toiletService.page(page,queryWrapper);
        List<Toilet> toilets = iPage.getRecords();
        for (Toilet toilet : toilets) {
            toilet.setType(TpyeEnum.findEnumByCode(toilet.getType()));
            toilet.setStatus(StatusEnum.findEnumByCode(toilet.getStatus()));
            toilet.setSex(SexEnum.findEnumByCode(toilet.getSex()));
            toilet.setPlaceNo(PlaceNoEnum.findEnumByCode(toilet.getPlaceNo()));
            toilet.setHealth(HealthEnum.findEnumByCode(toilet.getHealth()));
        }
        return iPage;
    }

    /**
     * 导出
     */
    @RequestMapping(value = "/export",method = RequestMethod.GET)
    public void export(HttpServletResponse response) throws Exception{
        List<Toilet> list = toiletService.list();
        for (Toilet toilet : list) {
            toilet.setType(TpyeEnum.findEnumByCode(toilet.getType()));
            toilet.setStatus(StatusEnum.findEnumByCode(toilet.getStatus()));
            toilet.setSex(SexEnum.findEnumByCode(toilet.getSex()));
            toilet.setPlaceNo(PlaceNoEnum.findEnumByCode(toilet.getPlaceNo()));
            toilet.setHealth(HealthEnum.findEnumByCode(toilet.getHealth()));
        }
        ExcelWriter writer = ExcelUtil.getWriter(true);

        writer.addHeaderAlias("id","id123");
        writer.addHeaderAlias("type","类型");
        writer.addHeaderAlias("status","状态");
        writer.addHeaderAlias("placeNo","大楼");
        writer.addHeaderAlias("placeDetail","详细位置");
        writer.addHeaderAlias("sex","性别");
        writer.addHeaderAlias("health","卫生");
        writer.addHeaderAlias("useNum","今日使用次数");
        writer.addHeaderAlias("useNumCount","总次数");
        writer.addHeaderAlias("setupTime","启用时间");
        writer.addHeaderAlias("cleanTime","上次清洁时间");

        writer.write(list,true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("坑位信息表","UTF-8");
        response.setHeader("Content-Disposition","attachment;filename="+fileName+".xlsx");

        ServletOutputStream out=response.getOutputStream();
        writer.flush(out,true);
        out.close();
        writer.close();
    }

    @Resource
    ToiletMapper toiletMapper;
    /**
     * 统计图1
     */
    @RequestMapping(value = "getDatabytype",method = RequestMethod.GET)
    public List getDatabytype(){

        QueryWrapper<Toilet> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("type as name,count(*) as value");
        queryWrapper.groupBy("type");
        List<Map<String, Object>> list = toiletMapper.selectMaps(queryWrapper);

        String[] itemStyles = {"red","#1FC48D","#6DC8EC"};
        List<EchDataOne> newList = new ArrayList<>();
        String name,value;
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> mapx = list.get(i);
            name =  TpyeEnum.findEnumByCode(String.valueOf(mapx.get("name")));
            value = String.valueOf( list.get(i).get("value"));
            newList.add(new EchDataOne(name,value,itemStyles[i]));
        }

        return newList;
    }
    /**
     * 统计图2
     */
    @GetMapping("getDataByTu2")
    public Result getDataByTu2(){
        Result result = null;
        try {
            Map<String,Object> map = toiletService.getDataByTu2();
            result = Result.success(map);
        }catch (Exception e){
            result = Result.error(ResultCode.RESULT_DATA_NONE);
        }
        return result;
    }

    /**
     * 统计图3
     */
    @GetMapping("getDataByTu3")
    public Result getDataByTu3(){
        Result result = null;
        try {
            QueryWrapper<Toilet> queryWrapper = new QueryWrapper<>();
            queryWrapper.select("place_no as name,count(*) as value");
            queryWrapper.groupBy("place_no");
            List<Map<String, Object>> maps = toiletMapper.selectMaps(queryWrapper);
            result = Result.success(maps);
        }catch (Exception e){
            result = Result.error(ResultCode.RESULT_DATA_NONE);
        }
        return result;
    }
}
