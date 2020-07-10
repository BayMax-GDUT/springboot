package com.cvaiedu.springboot.business.mapper;


import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import com.cvaiedu.springboot.business.entity.PublicCourse;

import java.util.List;

@Mapper
@Repository
public interface PublicCourseMapper extends BaseMapper<PublicCourse>  {
	
	List<PublicCourse> list(PublicCourse entity);
	
}
