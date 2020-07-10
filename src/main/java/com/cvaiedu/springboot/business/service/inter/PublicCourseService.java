package com.cvaiedu.springboot.business.service.inter;

import com.cvaiedu.springboot.business.entity.PublicCourse;

import java.util.List;
import java.util.Map;




/**
 * 服务实现层接口
 *
 * @author code-generator
 * @date 2020-06-03 17:24:29
 */
public interface PublicCourseService {
	
	List<PublicCourse> list(Map<String, Object> queryMap);
}
