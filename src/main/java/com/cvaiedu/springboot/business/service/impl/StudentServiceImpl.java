package com.cvaiedu.springboot.business.service.impl;

import com.alibaba.fastjson.JSONObject;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import com.cvaiedu.springboot.business.service.inter.StudentService;
import com.cvaiedu.springboot.business.entity.Student;
import com.cvaiedu.springboot.business.mapper.StudentMapper;

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
 * @date 2020-07-06 17:29:15
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;
	


    @Override
    public Student getByPrimaryKey(Long id) {
        Student entity = studentMapper.selectById(id);
        return entity;
    }
	
	@Override
	public PageUtils list(Map<String, Object> queryMap) {
        Query<?> query = new Query<>(queryMap);
        Page<Student> page = new Page<>(query.getCurrPage(), query.getLimit());
        Student entity = JSONObject.parseObject(JSONObject.toJSONString(queryMap), Student.class);
        EntityWrapper<Student> eWrapper = new EntityWrapper<>(entity);
        page.setRecords(studentMapper.selectPage(page, eWrapper));
        return new PageUtils(page);
	}
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Student entity) {
    	studentMapper.insert(entity);
    }

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteById(List<Long> ids){
		studentMapper.deleteBatchIds(ids);
	}

	@Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateById(Student entity) {			
    	studentMapper.updateById(entity);
    }


}
