package com.dao;

import com.entity.DiscussgangweixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussgangweixinxiVO;
import com.entity.view.DiscussgangweixinxiView;


/**
 * 岗位信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-22 16:07:53
 */
public interface DiscussgangweixinxiDao extends BaseMapper<DiscussgangweixinxiEntity> {
	
	List<DiscussgangweixinxiVO> selectListVO(@Param("ew") Wrapper<DiscussgangweixinxiEntity> wrapper);
	
	DiscussgangweixinxiVO selectVO(@Param("ew") Wrapper<DiscussgangweixinxiEntity> wrapper);
	
	List<DiscussgangweixinxiView> selectListView(@Param("ew") Wrapper<DiscussgangweixinxiEntity> wrapper);

	List<DiscussgangweixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussgangweixinxiEntity> wrapper);

	
	DiscussgangweixinxiView selectView(@Param("ew") Wrapper<DiscussgangweixinxiEntity> wrapper);
	

}
