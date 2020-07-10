package com.cvaiedu.springboot.business.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cvaiedu.springboot.business.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper extends BaseMapper<Student>  {
	
	List<Student> getListByCourseId(Long courseId);
	
}
