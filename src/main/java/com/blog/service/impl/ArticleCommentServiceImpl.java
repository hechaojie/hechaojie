package com.blog.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.service.ArticleCommentService;
import com.blog.service.core.entity.ArticleComment;
import com.blog.service.core.entity.ArticleCommentReply;
import com.blog.service.core.vo.ArticleCommentVo;
import com.blog.service.dao.ArticleCommentDao;
import com.blog.service.dao.ArticleCommentReplyDao;
import com.hecj.common.util.GenerateUtil;
import com.hecj.common.util.result.Pagination;
import com.hecj.common.util.result.Result;
import com.hecj.common.util.result.ResultSupport;

@Service("articleCommentService")
public class ArticleCommentServiceImpl implements ArticleCommentService {

	@Autowired
	public ArticleCommentDao articleCommentDao;
	
	@Autowired
	public ArticleCommentReplyDao articleCommentReplyDao;
	
	@Override
	public Result findByConditions(Map<String,Object> p,Pagination pg) {
		Result result = new ResultSupport();
		
		List<ArticleCommentVo> list = articleCommentDao.findByConditions(p,pg.getStartCursor(),pg.getPageSize());
		long total = articleCommentDao.countByConditions(p);
		result.setData(list);
		pg.setCountSize(total);
		result.setPagination(pg);
		return result;
	}

	@Override
	public long insertArticleComment(ArticleComment ac) {
		ac.setId(GenerateUtil.generateId());
		ac.setCreateAt(System.currentTimeMillis());
		return articleCommentDao.insert(ac);
	}

	@Override
	public List<ArticleCommentReply> findArticleCommentReplyByCommentId(String commentId) {
		List<ArticleCommentReply> list = articleCommentReplyDao.findByCommentId(commentId);
		return list;
	}

	@Override
	public long insertArticleCommentReply(ArticleCommentReply acr) {
		acr.setId(GenerateUtil.generateId());
		acr.setCreateAt(System.currentTimeMillis());
		articleCommentReplyDao.insert(acr);
		return 0;
	}

}
