package com.cvaiedu.springboot.business.mapper;


import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import com.cvaiedu.springboot.business.entity.Teacher;

@Mapper
@Repository
public interface TeacherMapper extends BaseMapper<Teacher>  {
	
	
	
}
