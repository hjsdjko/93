package com.dao;

import com.entity.DiscussgongsiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussgongsiVO;
import com.entity.view.DiscussgongsiView;


/**
 * 公司评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-22 16:07:53
 */
public interface DiscussgongsiDao extends BaseMapper<DiscussgongsiEntity> {
	
	List<DiscussgongsiVO> selectListVO(@Param("ew") Wrapper<DiscussgongsiEntity> wrapper);
	
	DiscussgongsiVO selectVO(@Param("ew") Wrapper<DiscussgongsiEntity> wrapper);
	
	List<DiscussgongsiView> selectListView(@Param("ew") Wrapper<DiscussgongsiEntity> wrapper);

	List<DiscussgongsiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussgongsiEntity> wrapper);

	
	DiscussgongsiView selectView(@Param("ew") Wrapper<DiscussgongsiEntity> wrapper);
	

}
