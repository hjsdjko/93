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
import com.utils.UserBasedCollaborativeFiltering;

import com.entity.GangweixinxiEntity;
import com.entity.view.GangweixinxiView;

import com.service.GangweixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 岗位信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-22 16:07:52
 */
@RestController
@RequestMapping("/gangweixinxi")
public class GangweixinxiController {
    @Autowired
    private GangweixinxiService gangweixinxiService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GangweixinxiEntity gangweixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("gongsi")) {
			gangweixinxi.setGongsizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GangweixinxiEntity> ew = new EntityWrapper<GangweixinxiEntity>();

		PageUtils page = gangweixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gangweixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GangweixinxiEntity gangweixinxi, 
		HttpServletRequest request){
        EntityWrapper<GangweixinxiEntity> ew = new EntityWrapper<GangweixinxiEntity>();

		PageUtils page = gangweixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gangweixinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GangweixinxiEntity gangweixinxi){
       	EntityWrapper<GangweixinxiEntity> ew = new EntityWrapper<GangweixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gangweixinxi, "gangweixinxi")); 
        return R.ok().put("data", gangweixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GangweixinxiEntity gangweixinxi){
        EntityWrapper< GangweixinxiEntity> ew = new EntityWrapper< GangweixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gangweixinxi, "gangweixinxi")); 
		GangweixinxiView gangweixinxiView =  gangweixinxiService.selectView(ew);
		return R.ok("查询岗位信息成功").put("data", gangweixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GangweixinxiEntity gangweixinxi = gangweixinxiService.selectById(id);
		gangweixinxi.setClicknum(gangweixinxi.getClicknum()+1);
		gangweixinxiService.updateById(gangweixinxi);
        gangweixinxi = gangweixinxiService.selectView(new EntityWrapper<GangweixinxiEntity>().eq("id", id));
        return R.ok().put("data", gangweixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GangweixinxiEntity gangweixinxi = gangweixinxiService.selectById(id);
		gangweixinxi.setClicknum(gangweixinxi.getClicknum()+1);
		gangweixinxiService.updateById(gangweixinxi);
        gangweixinxi = gangweixinxiService.selectView(new EntityWrapper<GangweixinxiEntity>().eq("id", id));
        return R.ok().put("data", gangweixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GangweixinxiEntity gangweixinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(gangweixinxi);
        gangweixinxiService.insert(gangweixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GangweixinxiEntity gangweixinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(gangweixinxi);
        gangweixinxiService.insert(gangweixinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GangweixinxiEntity gangweixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gangweixinxi);
        gangweixinxiService.updateById(gangweixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gangweixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,GangweixinxiEntity gangweixinxi, HttpServletRequest request,String pre){
        EntityWrapper<GangweixinxiEntity> ew = new EntityWrapper<GangweixinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = gangweixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gangweixinxi), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（基于用户收藏的协同算法）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,GangweixinxiEntity gangweixinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("tablename", "gangweixinxi"));
        Map<String, Map<String, Double>> ratings = new HashMap<>();
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity storeup : storeups) {
                Map<String, Double> userRatings = null;
                if(ratings.containsKey(storeup.getUserid().toString())) {
                    userRatings = ratings.get(storeup.getUserid().toString());
                } else {
                    userRatings = new HashMap<>();
                    ratings.put(storeup.getUserid().toString(), userRatings);
                }

                if(userRatings.containsKey(storeup.getRefid().toString())) {
                    userRatings.put(storeup.getRefid().toString(), userRatings.get(storeup.getRefid().toString())+1.0);
                } else {
                    userRatings.put(storeup.getRefid().toString(), 1.0);
                }
            }
        }
        // 创建协同过滤对象
        UserBasedCollaborativeFiltering filter = new UserBasedCollaborativeFiltering(ratings);

        // 为指定用户推荐物品
        String targetUser = userId;
        int numRecommendations = limit;
        List<String> recommendations = filter.recommendItems(targetUser, numRecommendations);

        // 输出推荐结果
        System.out.println("Recommendations for " + targetUser + ":");
        for (String item : recommendations) {
            System.out.println(item);
        }

        EntityWrapper<GangweixinxiEntity> ew = new EntityWrapper<GangweixinxiEntity>();
        ew.in("id", String.join(",", recommendations));
        if(recommendations!=null && recommendations.size()>0) {
            ew.last("order by FIELD(id, "+"'"+String.join("','", recommendations)+"'"+")");
        }

        PageUtils page = gangweixinxiService.queryPage(params, ew);
        List<GangweixinxiEntity> pageList = (List<GangweixinxiEntity>)page.getList();
        if(pageList.size()<limit) {
            int toAddNum = limit-pageList.size();
            ew = new EntityWrapper<GangweixinxiEntity>();
            ew.notIn("id", recommendations);
            ew.orderBy("id", false);
            ew.last("limit "+toAddNum);
            pageList.addAll(gangweixinxiService.selectList(ew));
        } else if(pageList.size()>limit) {
            pageList = pageList.subList(0, limit);
        }
        page.setList(pageList);

        return R.ok().put("data", page);
    }








}
