package com.cmr.datasource.dao.jpa;

import com.cmr.datasource.entity.jpa.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{

    Optional<UserEntity> findById(Long id);

}
