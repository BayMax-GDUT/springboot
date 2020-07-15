package com.cvaiedu.springboot.business.service.inter;

import com.cvaiedu.springboot.business.entity.Teacher;
import com.cvaiedu.springboot.utils.PageUtils;
import java.util.List;
import java.util.Map;




/**
 * 服务实现层接口
 *
 * @author code-generator
 * @date 2020-07-06 17:22:42
 */
public interface TeacherService {
	
    Teacher getByPrimaryKey(Long id);

    Teacher selectOne(Teacher entity);
	
	PageUtils list(Map<String, Object> queryMap);
    
    void save(Teacher entity);

	void deleteById(List<Long> ids);

    void updateById(Teacher entity);
}
