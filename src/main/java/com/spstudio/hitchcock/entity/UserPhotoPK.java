package com.spstudio.hitchcock.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Embeddable
@Data
public class UserPhotoPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -667688409394985692L;

	@NotNull
	private final Long userId;
	
	@NotNull
	private final Long photoId;
}
