package com.cvaiedu.springboot.business.service.impl;

import com.alibaba.fastjson.JSONObject;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import com.cvaiedu.springboot.business.service.inter.TeacherService;
import com.cvaiedu.springboot.business.entity.Teacher;
import com.cvaiedu.springboot.business.mapper.TeacherMapper;

import com.cvaiedu.springboot.utils.PageUtils;
import com.cvaiedu.springboot.utils.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


/**
 * 服务实现层
 *
 * @author code-generator
 * @date 2020-07-06 17:22:42
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;
	


    @Override
    public Teacher getByPrimaryKey(Long id) {
        Teacher entity = teacherMapper.selectById(id);
        return entity;
    }

    @Override
    public Teacher selectOne(Teacher entity) {
        return teacherMapper.selectOne(entity);
    }

    @Override
	public PageUtils list(Map<String, Object> queryMap) {
        Query<?> query = new Query<>(queryMap);
        Page<Teacher> page = new Page<>(query.getCurrPage(), query.getLimit());
        Teacher entity = JSONObject.parseObject(JSONObject.toJSONString(queryMap), Teacher.class);
        EntityWrapper<Teacher> eWrapper = new EntityWrapper<>(entity);
        page.setRecords(teacherMapper.selectPage(page, eWrapper));
        return new PageUtils(page);
	}
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Teacher entity) {
    	teacherMapper.insert(entity);
    }

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteById(List<Long> ids){
		teacherMapper.deleteBatchIds(ids);
	}

	@Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateById(Teacher entity) {
    	teacherMapper.updateById(entity);
    }


}
