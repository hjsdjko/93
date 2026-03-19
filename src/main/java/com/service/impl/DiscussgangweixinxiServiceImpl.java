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


import com.dao.DiscussgangweixinxiDao;
import com.entity.DiscussgangweixinxiEntity;
import com.service.DiscussgangweixinxiService;
import com.entity.vo.DiscussgangweixinxiVO;
import com.entity.view.DiscussgangweixinxiView;

@Service("discussgangweixinxiService")
public class DiscussgangweixinxiServiceImpl extends ServiceImpl<DiscussgangweixinxiDao, DiscussgangweixinxiEntity> implements DiscussgangweixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussgangweixinxiEntity> page = this.selectPage(
                new Query<DiscussgangweixinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussgangweixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussgangweixinxiEntity> wrapper) {
		  Page<DiscussgangweixinxiView> page =new Query<DiscussgangweixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussgangweixinxiVO> selectListVO(Wrapper<DiscussgangweixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussgangweixinxiVO selectVO(Wrapper<DiscussgangweixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussgangweixinxiView> selectListView(Wrapper<DiscussgangweixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussgangweixinxiView selectView(Wrapper<DiscussgangweixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
