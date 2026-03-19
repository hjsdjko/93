package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 公司
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-22 16:07:51
 */
@TableName("gongsi")
public class GongsiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GongsiEntity() {
		
	}
	
	public GongsiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId
    private Long id;
	/**
	 * 公司账号
	 */
					
	private String gongsizhanghao;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：公司账号
	 */
	public void setGongsizhanghao(String gongsizhanghao) {
		this.gongsizhanghao = gongsizhanghao;
	}
	/**
	 * 获取：公司账号
	 */
	public String getGongsizhanghao() {
		return gongsizhanghao;
	}
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
