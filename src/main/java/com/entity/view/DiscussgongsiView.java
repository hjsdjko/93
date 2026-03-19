package com.entity.view;

import com.entity.DiscussgongsiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 公司评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-22 16:07:53
 */
@TableName("discussgongsi")
public class DiscussgongsiView  extends DiscussgongsiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussgongsiView(){
	}
 
 	public DiscussgongsiView(DiscussgongsiEntity discussgongsiEntity){
 	try {
			BeanUtils.copyProperties(this, discussgongsiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
