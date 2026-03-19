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


import com.dao.MianshitongzhiDao;
import com.entity.MianshitongzhiEntity;
import com.service.MianshitongzhiService;
import com.entity.vo.MianshitongzhiVO;
import com.entity.view.MianshitongzhiView;

@Service("mianshitongzhiService")
public class MianshitongzhiServiceImpl extends ServiceImpl<MianshitongzhiDao, MianshitongzhiEntity> implements MianshitongzhiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MianshitongzhiEntity> page = this.selectPage(
                new Query<MianshitongzhiEntity>(params).getPage(),
                new EntityWrapper<MianshitongzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MianshitongzhiEntity> wrapper) {
		  Page<MianshitongzhiView> page =new Query<MianshitongzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<MianshitongzhiVO> selectListVO(Wrapper<MianshitongzhiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MianshitongzhiVO selectVO(Wrapper<MianshitongzhiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MianshitongzhiView> selectListView(Wrapper<MianshitongzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MianshitongzhiView selectView(Wrapper<MianshitongzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
