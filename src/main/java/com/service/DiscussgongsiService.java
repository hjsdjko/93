package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussgongsiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussgongsiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussgongsiView;


/**
 * 公司评论表
 *
 * @author 
 * @email 
 * @date 2024-03-22 16:07:53
 */
public interface DiscussgongsiService extends IService<DiscussgongsiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussgongsiVO> selectListVO(Wrapper<DiscussgongsiEntity> wrapper);
   	
   	DiscussgongsiVO selectVO(@Param("ew") Wrapper<DiscussgongsiEntity> wrapper);
   	
   	List<DiscussgongsiView> selectListView(Wrapper<DiscussgongsiEntity> wrapper);
   	
   	DiscussgongsiView selectView(@Param("ew") Wrapper<DiscussgongsiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussgongsiEntity> wrapper);

   	

}

