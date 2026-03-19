package com.entity.view;

import com.entity.GangweixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 岗位信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-22 16:07:52
 */
@TableName("gangweixinxi")
public class GangweixinxiView  extends GangweixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GangweixinxiView(){
	}
 
 	public GangweixinxiView(GangweixinxiEntity gangweixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, gangweixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
