package com.cvaiedu.springboot.business.service.impl;

import com.alibaba.fastjson.JSONObject;

import com.baomidou.mybatisplus.plugins.Page;

import com.cvaiedu.springboot.business.service.inter.PublicCourseService;
import com.github.pagehelper.PageHelper;
import com.cvaiedu.springboot.business.entity.PublicCourse;
import com.cvaiedu.springboot.business.mapper.PublicCourseMapper;

import com.cvaiedu.springboot.utils.Query;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * 服务实现层
 *
 * @author code-generator
 * @date 2020-06-03 17:24:29
 */
@Service
public class PublicCourseServiceImpl implements PublicCourseService {

    @Resource
    private PublicCourseMapper publicCourseMapper;

    @Override
	public List<PublicCourse> list(Map<String, Object> queryMap) {
        Query<?> query = new Query<>(queryMap);
        Page<PublicCourse> page = new Page<>(query.getCurrPage(), query.getLimit());
        PublicCourse entity = JSONObject.parseObject(JSONObject.toJSONString(queryMap), PublicCourse.class);
        PageHelper.offsetPage(0, 5);
        List<PublicCourse> list = publicCourseMapper.list(entity);
//        ObjectUtils<PublicCourse> publicCourseObjectUtils = new ObjectUtils<>();
//        publicCourseObjectUtils.sortByField(list, "teacherId");
        return list;
	}
}
