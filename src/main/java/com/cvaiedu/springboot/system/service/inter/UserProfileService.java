package com.cvaiedu.springboot.system.service.inter;

import com.cvaiedu.springboot.system.entity.Account;
import com.cvaiedu.springboot.system.entity.UserProfile;
import com.cvaiedu.springboot.utils.PageUtils;
import java.util.List;
import java.util.Map;




/**
 * 服务实现层接口
 *
 * @author code-generator
 * @date 2020-07-06 17:23:09
 */
public interface UserProfileService {
	
    UserProfile getByPrimaryKey(Long id);

    UserProfile selectOne(UserProfile entity);

	PageUtils list(Map<String, Object> queryMap);
    
    void save(UserProfile entity);

	void deleteById(List<Long> ids);

    void updateById(UserProfile entity);
}
