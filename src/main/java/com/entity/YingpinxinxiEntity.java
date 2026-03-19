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
 * 应聘信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-22 16:07:52
 */
@TableName("yingpinxinxi")
public class YingpinxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YingpinxinxiEntity() {
		
	}
	
	public YingpinxinxiEntity(T t) {
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
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 应聘编号
	 */
					
	private String yingpinbianhao;
	
	/**
	 * 公司名称
	 */
					
	private String gongsimingcheng;
	
	/**
	 * 岗位名称
	 */
					
	private String gangweimingcheng;
	
	/**
	 * 岗位分类
	 */
					
	private String gangweifenlei;
	
	/**
	 * 应聘照片
	 */
					
	private String fengmian;
	
	/**
	 * 应聘时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date yingpinshijian;
	
	/**
	 * 应聘简历
	 */
					
	private String yingpinjianli;
	
	/**
	 * 应聘详情
	 */
					
	private String yingpinxiangqing;
	
	/**
	 * 公司账号
	 */
					
	private String gongsizhanghao;
	
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	
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
	 * 设置：应聘编号
	 */
	public void setYingpinbianhao(String yingpinbianhao) {
		this.yingpinbianhao = yingpinbianhao;
	}
	/**
	 * 获取：应聘编号
	 */
	public String getYingpinbianhao() {
		return yingpinbianhao;
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
	 * 设置：岗位名称
	 */
	public void setGangweimingcheng(String gangweimingcheng) {
		this.gangweimingcheng = gangweimingcheng;
	}
	/**
	 * 获取：岗位名称
	 */
	public String getGangweimingcheng() {
		return gangweimingcheng;
	}
	/**
	 * 设置：岗位分类
	 */
	public void setGangweifenlei(String gangweifenlei) {
		this.gangweifenlei = gangweifenlei;
	}
	/**
	 * 获取：岗位分类
	 */
	public String getGangweifenlei() {
		return gangweifenlei;
	}
	/**
	 * 设置：应聘照片
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：应聘照片
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：应聘时间
	 */
	public void setYingpinshijian(Date yingpinshijian) {
		this.yingpinshijian = yingpinshijian;
	}
	/**
	 * 获取：应聘时间
	 */
	public Date getYingpinshijian() {
		return yingpinshijian;
	}
	/**
	 * 设置：应聘简历
	 */
	public void setYingpinjianli(String yingpinjianli) {
		this.yingpinjianli = yingpinjianli;
	}
	/**
	 * 获取：应聘简历
	 */
	public String getYingpinjianli() {
		return yingpinjianli;
	}
	/**
	 * 设置：应聘详情
	 */
	public void setYingpinxiangqing(String yingpinxiangqing) {
		this.yingpinxiangqing = yingpinxiangqing;
	}
	/**
	 * 获取：应聘详情
	 */
	public String getYingpinxiangqing() {
		return yingpinxiangqing;
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
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
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
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}

}
