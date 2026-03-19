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

import com.entity.GongsiEntity;
import com.entity.view.GongsiView;

import com.service.GongsiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 公司
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-22 16:07:51
 */
@RestController
@RequestMapping("/gongsi")
public class GongsiController {
    @Autowired
    private GongsiService gongsiService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		GongsiEntity u = gongsiService.selectOne(new EntityWrapper<GongsiEntity>().eq("gongsizhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"gongsi",  "公司" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody GongsiEntity gongsi){
    	//ValidatorUtils.validateEntity(gongsi);
    	GongsiEntity u = gongsiService.selectOne(new EntityWrapper<GongsiEntity>().eq("gongsizhanghao", gongsi.getGongsizhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		gongsi.setId(uId);
        gongsiService.insert(gongsi);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        GongsiEntity u = gongsiService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	GongsiEntity u = gongsiService.selectOne(new EntityWrapper<GongsiEntity>().eq("gongsizhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        gongsiService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GongsiEntity gongsi,
		HttpServletRequest request){
        EntityWrapper<GongsiEntity> ew = new EntityWrapper<GongsiEntity>();

		PageUtils page = gongsiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongsi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GongsiEntity gongsi, 
		HttpServletRequest request){
        EntityWrapper<GongsiEntity> ew = new EntityWrapper<GongsiEntity>();

		PageUtils page = gongsiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongsi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GongsiEntity gongsi){
       	EntityWrapper<GongsiEntity> ew = new EntityWrapper<GongsiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongsi, "gongsi")); 
        return R.ok().put("data", gongsiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GongsiEntity gongsi){
        EntityWrapper< GongsiEntity> ew = new EntityWrapper< GongsiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongsi, "gongsi")); 
		GongsiView gongsiView =  gongsiService.selectView(ew);
		return R.ok("查询公司成功").put("data", gongsiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GongsiEntity gongsi = gongsiService.selectById(id);
        return R.ok().put("data", gongsi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GongsiEntity gongsi = gongsiService.selectById(id);
        return R.ok().put("data", gongsi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GongsiEntity gongsi, HttpServletRequest request){
        if(gongsiService.selectCount(new EntityWrapper<GongsiEntity>().eq("gongsizhanghao", gongsi.getGongsizhanghao()))>0) {
            return R.error("公司账号已存在");
        }
    	gongsi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongsi);
    	GongsiEntity u = gongsiService.selectOne(new EntityWrapper<GongsiEntity>().eq("gongsizhanghao", gongsi.getGongsizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		gongsi.setId(new Date().getTime());
        gongsiService.insert(gongsi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GongsiEntity gongsi, HttpServletRequest request){
        if(gongsiService.selectCount(new EntityWrapper<GongsiEntity>().eq("gongsizhanghao", gongsi.getGongsizhanghao()))>0) {
            return R.error("公司账号已存在");
        }
    	gongsi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongsi);
    	GongsiEntity u = gongsiService.selectOne(new EntityWrapper<GongsiEntity>().eq("gongsizhanghao", gongsi.getGongsizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		gongsi.setId(new Date().getTime());
        gongsiService.insert(gongsi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GongsiEntity gongsi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongsi);
        if(gongsiService.selectCount(new EntityWrapper<GongsiEntity>().ne("id", gongsi.getId()).eq("gongsizhanghao", gongsi.getGongsizhanghao()))>0) {
            return R.error("公司账号已存在");
        }
        gongsiService.updateById(gongsi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gongsiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
