package com.cvaiedu.springboot.business.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * mapper 继承类
 * @param <T>
 * @author code-generator
 * @date 2020-06-03 17:24:29
 */
@Mapper
@Repository
public interface BaseMapper<T, PK extends Serializable> {
		
}
