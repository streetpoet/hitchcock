package com.spstudio.hitchcock.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;
import lombok.Generated;

@Data
@Generated
@Entity
public class UserPhotoRef {

	@EmbeddedId
	private UserPhotoPK id;

	private boolean enabled;
}
