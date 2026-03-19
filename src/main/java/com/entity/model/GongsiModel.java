package com.entity.model;

import com.entity.GongsiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 公司
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-03-22 16:07:51
 */
public class GongsiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	
	private String mima;
		
	/**
	 * 公司名称
	 */
	
	private String gongsimingcheng;
		
	/**
	 * 公司电话
	 */
	
	private String gongsidianhua;
		
	/**
	 * 公司邮箱
	 */
	
	private String gongsiyouxiang;
		
	/**
	 * 公司类型
	 */
	
	private String gongsileixing;
		
	/**
	 * 公司封面
	 */
	
	private String gongsifengmian;
		
	/**
	 * 公司介绍
	 */
	
	private String gongsijieshao;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
				
	
	/**
	 * 设置：密码
	 */
	 
	public void setMima(String mima) {
		this.mima = mima;
	}
	
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}
				
	
	/**
	 * 设置：公司名称
	 */
	 
	public void setGongsimingcheng(String gongsimingcheng) {
		this.gongsimingcheng = gongsimingcheng;
	}
	
	/**
	 * 获取：公司名称
	 */
	public String getGongsimingcheng() {
		return gongsimingcheng;
	}
				
	
	/**
	 * 设置：公司电话
	 */
	 
	public void setGongsidianhua(String gongsidianhua) {
		this.gongsidianhua = gongsidianhua;
	}
	
	/**
	 * 获取：公司电话
	 */
	public String getGongsidianhua() {
		return gongsidianhua;
	}
				
	
	/**
	 * 设置：公司邮箱
	 */
	 
	public void setGongsiyouxiang(String gongsiyouxiang) {
		this.gongsiyouxiang = gongsiyouxiang;
	}
	
	/**
	 * 获取：公司邮箱
	 */
	public String getGongsiyouxiang() {
		return gongsiyouxiang;
	}
				
	
	/**
	 * 设置：公司类型
	 */
	 
	public void setGongsileixing(String gongsileixing) {
		this.gongsileixing = gongsileixing;
	}
	
	/**
	 * 获取：公司类型
	 */
	public String getGongsileixing() {
		return gongsileixing;
	}
				
	
	/**
	 * 设置：公司封面
	 */
	 
	public void setGongsifengmian(String gongsifengmian) {
		this.gongsifengmian = gongsifengmian;
	}
	
	/**
	 * 获取：公司封面
	 */
	public String getGongsifengmian() {
		return gongsifengmian;
	}
				
	
	/**
	 * 设置：公司介绍
	 */
	 
	public void setGongsijieshao(String gongsijieshao) {
		this.gongsijieshao = gongsijieshao;
	}
	
	/**
	 * 获取：公司介绍
	 */
	public String getGongsijieshao() {
		return gongsijieshao;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
			
}
