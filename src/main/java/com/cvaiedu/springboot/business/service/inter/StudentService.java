package com.cvaiedu.springboot.business.service.inter;

import com.cvaiedu.springboot.business.entity.Student;
import com.cvaiedu.springboot.utils.PageUtils;
import java.util.List;
import java.util.Map;




/**
 * 服务实现层接口
 *
 * @author code-generator
 * @date 2020-07-06 17:29:15
 */
public interface StudentService {
	
    Student getByPrimaryKey(Long id);
	
	PageUtils list(Map<String, Object> queryMap);
    
    void save(Student entity);

	void deleteById(List<Long> ids);

    void updateById(Student entity);
}
