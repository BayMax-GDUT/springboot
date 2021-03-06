package com.cvaiedu.springboot.system.service.inter;

import com.cvaiedu.springboot.system.entity.Account;
import com.cvaiedu.springboot.utils.PageUtils;

import java.util.List;
import java.util.Map;




/**
 * 服务实现层接口
 *
 * @author code-generator
 * @date 2020-07-06 17:09:38
 */
public interface AccountService {
	
    Account getByPrimaryKey(Long id);

    Account selectOne(Account entity);
	
	PageUtils list(Map<String, Object> queryMap);
    
    void save(Account entity);

	void deleteById(List<Long> ids);

    void updateById(Account entity);
}
