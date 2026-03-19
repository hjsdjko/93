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


import com.dao.DiscussgongsiDao;
import com.entity.DiscussgongsiEntity;
import com.service.DiscussgongsiService;
import com.entity.vo.DiscussgongsiVO;
import com.entity.view.DiscussgongsiView;

@Service("discussgongsiService")
public class DiscussgongsiServiceImpl extends ServiceImpl<DiscussgongsiDao, DiscussgongsiEntity> implements DiscussgongsiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussgongsiEntity> page = this.selectPage(
                new Query<DiscussgongsiEntity>(params).getPage(),
                new EntityWrapper<DiscussgongsiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussgongsiEntity> wrapper) {
		  Page<DiscussgongsiView> page =new Query<DiscussgongsiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussgongsiVO> selectListVO(Wrapper<DiscussgongsiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussgongsiVO selectVO(Wrapper<DiscussgongsiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussgongsiView> selectListView(Wrapper<DiscussgongsiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussgongsiView selectView(Wrapper<DiscussgongsiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
