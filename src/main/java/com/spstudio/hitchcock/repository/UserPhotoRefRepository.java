package com.spstudio.hitchcock.repository;

import org.springframework.data.repository.CrudRepository;

import com.spstudio.hitchcock.entity.UserPhotoPK;
import com.spstudio.hitchcock.entity.UserPhotoRef;

public interface UserPhotoRefRepository extends CrudRepository<UserPhotoRef, UserPhotoPK> {

}
