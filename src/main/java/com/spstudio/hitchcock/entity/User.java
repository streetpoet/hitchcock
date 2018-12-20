package com.spstudio.hitchcock.entity;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.Generated;

@Data
@Generated
public class User {

	private int id;
	@NotEmpty
	private String username;
}
