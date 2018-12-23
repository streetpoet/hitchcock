package com.spstudio.hitchcock.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Generated;

@Embeddable
@Data
@Generated
public class UserPhotoPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -667688409394985692L;

	@NotNull
	private Long userId;
	
	@NotNull
	private Long photoId;
}
