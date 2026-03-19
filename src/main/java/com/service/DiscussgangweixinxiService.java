package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussgangweixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussgangweixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussgangweixinxiView;


/**
 * 岗位信息评论表
 *
 * @author 
 * @email 
 * @date 2024-03-22 16:07:53
 */
public interface DiscussgangweixinxiService extends IService<DiscussgangweixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussgangweixinxiVO> selectListVO(Wrapper<DiscussgangweixinxiEntity> wrapper);
   	
   	DiscussgangweixinxiVO selectVO(@Param("ew") Wrapper<DiscussgangweixinxiEntity> wrapper);
   	
   	List<DiscussgangweixinxiView> selectListView(Wrapper<DiscussgangweixinxiEntity> wrapper);
   	
   	DiscussgangweixinxiView selectView(@Param("ew") Wrapper<DiscussgangweixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussgangweixinxiEntity> wrapper);

   	

}

