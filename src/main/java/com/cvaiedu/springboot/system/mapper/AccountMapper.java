package com.cvaiedu.springboot.system.mapper;


import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import com.cvaiedu.springboot.system.entity.AccountEntity;

@Mapper
@Repository
public interface AccountMapper extends BaseMapper<AccountEntity>  {
	
	
	
}
