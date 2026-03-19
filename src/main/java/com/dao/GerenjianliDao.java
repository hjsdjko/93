package com.dao;

import com.entity.GerenjianliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GerenjianliVO;
import com.entity.view.GerenjianliView;


/**
 * 个人简历
 * 
 * @author 
 * @email 
 * @date 2024-03-22 16:07:52
 */
public interface GerenjianliDao extends BaseMapper<GerenjianliEntity> {
	
	List<GerenjianliVO> selectListVO(@Param("ew") Wrapper<GerenjianliEntity> wrapper);
	
	GerenjianliVO selectVO(@Param("ew") Wrapper<GerenjianliEntity> wrapper);
	
	List<GerenjianliView> selectListView(@Param("ew") Wrapper<GerenjianliEntity> wrapper);

	List<GerenjianliView> selectListView(Pagination page,@Param("ew") Wrapper<GerenjianliEntity> wrapper);

	
	GerenjianliView selectView(@Param("ew") Wrapper<GerenjianliEntity> wrapper);
	

}
