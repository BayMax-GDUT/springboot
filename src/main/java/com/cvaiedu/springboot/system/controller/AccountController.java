package com.cvaiedu.springboot.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.cvaiedu.springboot.result.Result;
import com.cvaiedu.springboot.result.ResultEnum;
import com.cvaiedu.springboot.system.service.inter.AccountService;
import com.cvaiedu.springboot.system.entity.AccountEntity;

import com.cvaiedu.springboot.utils.PageUtils;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
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
 * @date 2020-07-06 17:09:38
 */
@RestController
@RequestMapping("/v1/account")
public class AccountController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AccountService service;

    /**
     * 根据Id 查询
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getByPrimaryKey")
    public Result getByPrimaryKey(@RequestParam Long id) {
		logger.info("根据Id查询 accountEntity，参数= {} ", JSONObject.toJSONString(id));
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
		logger.info("查询 accountEntity 列表，参数= {} ", JSONObject.toJSONString(queryMap));
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
    public Result save(@RequestBody @Validated AccountEntity entity, BindingResult bindingResult) {
		logger.info("新增 accountEntity，参数= {} ", JSONObject.toJSONString(entity));
		if (bindingResult.hasErrors()) {
 	       logger.error("新增 accountEntity 参数不正确,异常={}", bindingResult.getFieldError().getDefaultMessage());
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
    public Result updateById(@RequestBody @Validated AccountEntity entity, BindingResult bindingResult){
		logger.info("更新 accountEntity，参数= {} ", JSONObject.toJSONString(entity));
		if (bindingResult.hasErrors()) {
 	       logger.error("更新 accountEntity 参数不正确,异常={}", bindingResult.getFieldError().getDefaultMessage());
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
		logger.info("删除 accountEntity，参数= {} ", JSONObject.toJSONString(ids));
        service.deleteById(ids);
        return Result.ok();
    }
     
    
}

