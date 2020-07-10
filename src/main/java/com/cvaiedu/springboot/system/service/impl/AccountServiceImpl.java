package com.cvaiedu.springboot.system.service.impl;

import com.alibaba.fastjson.JSONObject;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import com.cvaiedu.springboot.system.service.inter.AccountService;
import com.cvaiedu.springboot.system.entity.AccountEntity;
import com.cvaiedu.springboot.system.mapper.AccountMapper;

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
 * @date 2020-07-06 17:09:38
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;
	


    @Override
    public AccountEntity getByPrimaryKey(Long id) {
        AccountEntity entity = accountMapper.selectById(id);
        return entity;
    }
	
	@Override
	public PageUtils list(Map<String, Object> queryMap) {
        Query<?> query = new Query<>(queryMap);
        Page<AccountEntity> page = new Page<>(query.getCurrPage(), query.getLimit());
        AccountEntity entity = JSONObject.parseObject(JSONObject.toJSONString(queryMap), AccountEntity.class);
        EntityWrapper<AccountEntity> eWrapper = new EntityWrapper<>(entity);
        page.setRecords(accountMapper.selectPage(page, eWrapper));
        return new PageUtils(page);
	}
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(AccountEntity entity) {
        entity.setCreateTime(new Date());		
    	accountMapper.insert(entity);
    }

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteById(List<Long> ids){
		accountMapper.deleteBatchIds(ids);
	}

	@Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateById(AccountEntity entity) {			
    	accountMapper.updateById(entity);
    }


}
