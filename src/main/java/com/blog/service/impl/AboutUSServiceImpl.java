package com.blog.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.service.AboutUSService;
import com.blog.service.core.entity.AboutUS;
import com.blog.service.dao.AboutUSDao;

@Service("aboutUSService")
public class AboutUSServiceImpl implements AboutUSService {

	@Autowired
	private AboutUSDao aboutUSDao;
	
	@Override
	public List<AboutUS> findAllByCondition(Map<String, Object> params) {
		return aboutUSDao.findAllByCondition(params);
	}

}
