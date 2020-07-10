package com.cvaiedu.springboot.system.service.inter;

import com.cvaiedu.springboot.system.entity.AccountEntity;
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
	
    AccountEntity getByPrimaryKey(Long id);
	
	PageUtils list(Map<String, Object> queryMap);
    
    void save(AccountEntity entity);

	void deleteById(List<Long> ids);

    void updateById(AccountEntity entity);
}
