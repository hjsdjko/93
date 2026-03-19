package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GongsiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GongsiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GongsiView;


/**
 * 公司
 *
 * @author 
 * @email 
 * @date 2024-03-22 16:07:51
 */
public interface GongsiService extends IService<GongsiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GongsiVO> selectListVO(Wrapper<GongsiEntity> wrapper);
   	
   	GongsiVO selectVO(@Param("ew") Wrapper<GongsiEntity> wrapper);
   	
   	List<GongsiView> selectListView(Wrapper<GongsiEntity> wrapper);
   	
   	GongsiView selectView(@Param("ew") Wrapper<GongsiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GongsiEntity> wrapper);

   	

}

