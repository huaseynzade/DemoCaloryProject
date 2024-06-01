package org.caloryproject.repository;

import org.caloryproject.entity.UserActivateCode;
import org.caloryproject.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserActivationRepository extends CrudRepository<UserActivateCode, Integer> {

    Optional<UserActivateCode> findByUser(UserEntity user);

}
