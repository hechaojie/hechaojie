package com.blog.service.core.vo;

import java.io.Serializable;
import java.util.Date;

import com.hecj.common.util.date.DateFormatUtil;
/**
 * 文章业务类
 */
public class ArticleVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String id;
	
	public String userId;
	
	public String email;
	
	public String username;
	
	public String title;
	
	public String content;
	
	public String type;
	
	public int commentCount;
	
	public int recommend;
	
	public Long createAt;
	
	public Long updateAt;

	public ArticleVo() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public Long getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Long createAt) {
		this.createAt = createAt;
	}

	public Long getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Long updateAt) {
		this.updateAt = updateAt;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreateText(){
		return DateFormatUtil.date2Text(new Date(this.getCreateAt()));
	}
	
}
