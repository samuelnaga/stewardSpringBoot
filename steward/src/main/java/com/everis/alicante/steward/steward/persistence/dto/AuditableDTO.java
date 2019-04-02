package com.everis.alicante.steward.steward.persistence.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class AuditableDTO implements Serializable {

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private final Date creationDate = new Date();
	
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private final Date lastModifiedDate = new Date();
}
