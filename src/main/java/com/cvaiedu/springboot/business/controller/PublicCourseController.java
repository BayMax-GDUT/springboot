package com.cvaiedu.springboot.business.controller;

import com.alibaba.fastjson.JSONObject;
import com.cvaiedu.springboot.business.service.inter.PublicCourseService;
import com.cvaiedu.springboot.result.Result;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * 控制层
 * 通过拦截器，或者AOP的方式，处理异常信息
 *
 * @author code-generator
 * @date 2020-06-03 17:24:29
 */
@RestController
@RequestMapping("/v1/publicCourse")
public class PublicCourseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PublicCourseService service;

	/**
	 * 列表查询
     *
	 * @param queryMap
	 * @return
	 */
	@RequestMapping(value = "/list")
	public Result list(@RequestParam Map<String, Object> queryMap) {
		logger.info("查询 publicCourse 列表，参数= {} ", JSONObject.toJSONString(queryMap));
        return Result.ok(service.list(queryMap));
	}

}

