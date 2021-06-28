package com.splitwise.model;

import java.util.Date;

public abstract class AuditableEntity {
	
	private Long id;
	private Date createdAt;
	
	public AuditableEntity(Long id) {
		this.id = id;
		this.createdAt = new Date();
	}
	public Long getId() {
		return this.id;
	}
	public Date getCreatedAt() {
		return this.createdAt;
	}

}
