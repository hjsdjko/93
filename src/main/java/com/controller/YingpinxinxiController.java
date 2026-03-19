package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YingpinxinxiEntity;
import com.entity.view.YingpinxinxiView;

import com.service.YingpinxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 应聘信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-22 16:07:52
 */
@RestController
@RequestMapping("/yingpinxinxi")
public class YingpinxinxiController {
    @Autowired
    private YingpinxinxiService yingpinxinxiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YingpinxinxiEntity yingpinxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("gongsi")) {
			yingpinxinxi.setGongsizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			yingpinxinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YingpinxinxiEntity> ew = new EntityWrapper<YingpinxinxiEntity>();

		PageUtils page = yingpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yingpinxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YingpinxinxiEntity yingpinxinxi, 
		HttpServletRequest request){
        EntityWrapper<YingpinxinxiEntity> ew = new EntityWrapper<YingpinxinxiEntity>();

		PageUtils page = yingpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yingpinxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YingpinxinxiEntity yingpinxinxi){
       	EntityWrapper<YingpinxinxiEntity> ew = new EntityWrapper<YingpinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yingpinxinxi, "yingpinxinxi")); 
        return R.ok().put("data", yingpinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YingpinxinxiEntity yingpinxinxi){
        EntityWrapper< YingpinxinxiEntity> ew = new EntityWrapper< YingpinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yingpinxinxi, "yingpinxinxi")); 
		YingpinxinxiView yingpinxinxiView =  yingpinxinxiService.selectView(ew);
		return R.ok("查询应聘信息成功").put("data", yingpinxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YingpinxinxiEntity yingpinxinxi = yingpinxinxiService.selectById(id);
        return R.ok().put("data", yingpinxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YingpinxinxiEntity yingpinxinxi = yingpinxinxiService.selectById(id);
        return R.ok().put("data", yingpinxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YingpinxinxiEntity yingpinxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yingpinxinxi);
        yingpinxinxiService.insert(yingpinxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YingpinxinxiEntity yingpinxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yingpinxinxi);
        yingpinxinxiService.insert(yingpinxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YingpinxinxiEntity yingpinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yingpinxinxi);
        yingpinxinxiService.updateById(yingpinxinxi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<YingpinxinxiEntity> list = new ArrayList<YingpinxinxiEntity>();
        for(Long id : ids) {
            YingpinxinxiEntity yingpinxinxi = yingpinxinxiService.selectById(id);
            yingpinxinxi.setSfsh(sfsh);
            yingpinxinxi.setShhf(shhf);
            list.add(yingpinxinxi);
        }
        yingpinxinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yingpinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
