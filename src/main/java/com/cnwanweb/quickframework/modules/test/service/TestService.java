/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.cnwanweb.quickframework.modules.test.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cnwanweb.quickframework.common.service.CrudService;
import com.cnwanweb.quickframework.modules.test.entity.Test;
import com.cnwanweb.quickframework.modules.test.dao.TestDao;

/**
 * 测试Service
 * @author ThinkGem
 * @version 2013-10-17
 */
@Service
@Transactional(readOnly = true)
public class TestService extends CrudService<TestDao, Test> {

}
