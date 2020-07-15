package com.cvaiedu.springboot.system.service.impl;

import com.alibaba.fastjson.JSONObject;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import com.cvaiedu.springboot.system.entity.Account;
import com.cvaiedu.springboot.system.service.inter.UserProfileService;
import com.cvaiedu.springboot.system.entity.UserProfile;
import com.cvaiedu.springboot.system.mapper.UserProfileMapper;
import com.cvaiedu.springboot.utils.PageUtils;
import com.cvaiedu.springboot.utils.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Date;


/**
 * 服务实现层
 *
 * @author code-generator
 * @date 2020-07-06 17:23:09
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Resource
    private UserProfileMapper userProfileMapper;
	


    @Override
    public UserProfile getByPrimaryKey(Long id) {
        UserProfile entity = userProfileMapper.selectById(id);
        return entity;
    }

    @Override
    public UserProfile selectOne(UserProfile entity) {
        return userProfileMapper.selectOne(entity);
    }

    @Override
	public PageUtils list(Map<String, Object> queryMap) {
        Query<?> query = new Query<>(queryMap);
        Page<UserProfile> page = new Page<>(query.getCurrPage(), query.getLimit());
        UserProfile entity = JSONObject.parseObject(JSONObject.toJSONString(queryMap), UserProfile.class);
        EntityWrapper<UserProfile> eWrapper = new EntityWrapper<>(entity);
        page.setRecords(userProfileMapper.selectPage(page, eWrapper));
        return new PageUtils(page);
	}
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(UserProfile entity) {
        entity.setCreateTime(new Date());
        entity.setModifyTime(new Date());
    	userProfileMapper.insert(entity);
    }

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteById(List<Long> ids){
		userProfileMapper.deleteBatchIds(ids);
	}

	@Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateById(UserProfile entity) {
        entity.setModifyTime(new Date());
    	userProfileMapper.updateById(entity);
    }


}
