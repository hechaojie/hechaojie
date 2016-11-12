package com.blog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.service.UserService;
import com.blog.service.core.entity.User;
import com.blog.service.dao.EmailAuthTokenDao;
import com.blog.service.dao.UserDao;
import com.hecj.common.util.GenerateUtil;
import com.hecj.common.util.StringUtil;
import com.hecj.common.util.result.Pagination;
import com.hecj.common.util.result.Result;
import com.hecj.common.util.result.ResultSupport;
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private EmailAuthTokenDao emailAuthTokenDao;
	
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public Result findUsersByCondition(Map<String, Object> params, Pagination pagination) {
		Result result = new ResultSupport();
		try {
			
			Map<String, Object> sqlParams = new HashMap<String,Object>();
			if(!StringUtil.isObjectEmpty(params.get("email"))){
				sqlParams.put("email", params.get("email"));
			}
			
			List<User> userList = userDao.findUsersByConditions(sqlParams, pagination.getCurrPage(),pagination.getPageSize());
			long userTotal = userDao.totalUsersByConditions(sqlParams);
			
			pagination.setCountSize(userTotal);
			result.setData(userList);
			result.setPagination(pagination);
			result.setResult(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setResult(false);
		}
		return result;
	}

	@Override
	public User findUserByEmail(String email) {
		return userDao.findUserByEmail(email);
	}

	@Override
	public boolean addUser(User user) {
		user.setId(GenerateUtil.generateId());
		user.setCreateAt(System.currentTimeMillis());
		user.setUpdateAt(System.currentTimeMillis());
		userDao.save(user);
		return true;
	}

	@Override
	public boolean updatePassword(String id, String password) {
		return userDao.updateUserPasswd(id, password);
	}

	@Override
	public User findUserById(String id) {
		return userDao.findUserById(id);
	}

}
