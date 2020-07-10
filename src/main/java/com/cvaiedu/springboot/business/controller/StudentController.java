package com.cvaiedu.springboot.business.controller;

import com.alibaba.fastjson.JSONObject;
import com.cvaiedu.springboot.result.Result;
import com.cvaiedu.springboot.result.ResultEnum;
import com.cvaiedu.springboot.business.service.inter.StudentService;
import com.cvaiedu.springboot.business.entity.Student;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import com.cvaiedu.springboot.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;


/**
 * 控制层
 * 通过拦截器，或者AOP的方式，处理异常信息
 *
 * @author code-generator
 * @date 2020-07-06 17:29:15
 */
@RestController
@RequestMapping("/v1/student")
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StudentService service;

    /**
     * 根据Id 查询
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getByPrimaryKey")
    public Result getByPrimaryKey(@RequestParam Long id) {
		logger.info("根据Id查询 student，参数= {} ", JSONObject.toJSONString(id));
		return Result.ok(service.getByPrimaryKey(id));
    }
        
	/**
	 * 列表查询
     *
	 * @param queryMap
	 * @return
	 */
	@RequestMapping(value = "/list")
	public Result list(@RequestParam Map<String, Object> queryMap) {
		logger.info("查询 student 列表，参数= {} ", JSONObject.toJSONString(queryMap));
        PageUtils record = service.list(queryMap);
        return Result.ok(record);
	}
    
    /**
     * 新增数据
     *
     * @param entity
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/add")
    public Result save(@RequestBody @Validated Student entity, BindingResult bindingResult) {
		logger.info("新增 student，参数= {} ", JSONObject.toJSONString(entity));
		if (bindingResult.hasErrors()) {
 	       logger.error("新增 student 参数不正确,异常={}", bindingResult.getFieldError().getDefaultMessage());
 	       return Result.error(ResultEnum.ERROR_400.getCode(), bindingResult.getFieldError().getDefaultMessage());
 	    }
        service.save(entity);
        return Result.ok();
    }
	
	/**
     * 更新
     *
     * @param entity
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/update")
    public Result updateById(@RequestBody @Validated Student entity, BindingResult bindingResult){
		logger.info("更新 student，参数= {} ", JSONObject.toJSONString(entity));
		if (bindingResult.hasErrors()) {
 	       logger.error("更新 student 参数不正确,异常={}", bindingResult.getFieldError().getDefaultMessage());
 	       return Result.error(ResultEnum.ERROR_400.getCode(), bindingResult.getFieldError().getDefaultMessage());
 	    }
    	service.updateById(entity);
        return Result.ok();
    }
    

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @RequestMapping(value="/delete")
    public Result deleteById(@RequestBody List<Long> ids) {
		logger.info("删除 student，参数= {} ", JSONObject.toJSONString(ids));
        service.deleteById(ids);
        return Result.ok();
    }
     
    
}

