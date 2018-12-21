package com.spstudio.hitchcock.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.Generated;

@Data
@Generated
@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;
	
	@NotEmpty
	private String username;
}
