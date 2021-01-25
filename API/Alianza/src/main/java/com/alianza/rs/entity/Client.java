package com.alianza.rs.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "client")
@Getter
@Setter
public class Client implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_client", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 100, unique = true)
	private String sharedKey;
	@Column(nullable = false, length = 100)
	private String businessId;
	@Column(nullable = false, length = 100)
	private String email;
	private Long phone;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_added")
	private Date dateAdded;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_start")
	private Date dateStart;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_end")
	private Date dateEnd;
	
	
	

}
