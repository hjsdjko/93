package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.GongsiDao;
import com.entity.GongsiEntity;
import com.service.GongsiService;
import com.entity.vo.GongsiVO;
import com.entity.view.GongsiView;

@Service("gongsiService")
public class GongsiServiceImpl extends ServiceImpl<GongsiDao, GongsiEntity> implements GongsiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GongsiEntity> page = this.selectPage(
                new Query<GongsiEntity>(params).getPage(),
                new EntityWrapper<GongsiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GongsiEntity> wrapper) {
		  Page<GongsiView> page =new Query<GongsiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<GongsiVO> selectListVO(Wrapper<GongsiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GongsiVO selectVO(Wrapper<GongsiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GongsiView> selectListView(Wrapper<GongsiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GongsiView selectView(Wrapper<GongsiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
