package com.entity.model;

import com.entity.GerenjianliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 个人简历
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-03-22 16:07:52
 */
public class GerenjianliModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 用户电话
	 */
	
	private String yonghudianhua;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 学历
	 */
	
	private String xueli;
		
	/**
	 * 个人简历
	 */
	
	private String gerenjianli;
		
	/**
	 * 用户照片
	 */
	
	private String yonghuzhaopian;
		
	/**
	 * 教育背景
	 */
	
	private String jiaoyubeijing;
		
	/**
	 * 技能
	 */
	
	private String jineng;
		
	/**
	 * 实习经验
	 */
	
	private String shixijingyan;
		
	/**
	 * 项目经历
	 */
	
	private String xiangmujingli;
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：用户电话
	 */
	 
	public void setYonghudianhua(String yonghudianhua) {
		this.yonghudianhua = yonghudianhua;
	}
	
	/**
	 * 获取：用户电话
	 */
	public String getYonghudianhua() {
		return yonghudianhua;
	}
				
	
	/**
	 * 设置：性别
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：学历
	 */
	 
	public void setXueli(String xueli) {
		this.xueli = xueli;
	}
	
	/**
	 * 获取：学历
	 */
	public String getXueli() {
		return xueli;
	}
				
	
	/**
	 * 设置：个人简历
	 */
	 
	public void setGerenjianli(String gerenjianli) {
		this.gerenjianli = gerenjianli;
	}
	
	/**
	 * 获取：个人简历
	 */
	public String getGerenjianli() {
		return gerenjianli;
	}
				
	
	/**
	 * 设置：用户照片
	 */
	 
	public void setYonghuzhaopian(String yonghuzhaopian) {
		this.yonghuzhaopian = yonghuzhaopian;
	}
	
	/**
	 * 获取：用户照片
	 */
	public String getYonghuzhaopian() {
		return yonghuzhaopian;
	}
				
	
	/**
	 * 设置：教育背景
	 */
	 
	public void setJiaoyubeijing(String jiaoyubeijing) {
		this.jiaoyubeijing = jiaoyubeijing;
	}
	
	/**
	 * 获取：教育背景
	 */
	public String getJiaoyubeijing() {
		return jiaoyubeijing;
	}
				
	
	/**
	 * 设置：技能
	 */
	 
	public void setJineng(String jineng) {
		this.jineng = jineng;
	}
	
	/**
	 * 获取：技能
	 */
	public String getJineng() {
		return jineng;
	}
				
	
	/**
	 * 设置：实习经验
	 */
	 
	public void setShixijingyan(String shixijingyan) {
		this.shixijingyan = shixijingyan;
	}
	
	/**
	 * 获取：实习经验
	 */
	public String getShixijingyan() {
		return shixijingyan;
	}
				
	
	/**
	 * 设置：项目经历
	 */
	 
	public void setXiangmujingli(String xiangmujingli) {
		this.xiangmujingli = xiangmujingli;
	}
	
	/**
	 * 获取：项目经历
	 */
	public String getXiangmujingli() {
		return xiangmujingli;
	}
			
}
