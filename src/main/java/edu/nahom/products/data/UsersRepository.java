package edu.nahom.products.data;

import org.springframework.data.repository.CrudRepository;

import edu.nahom.products.models.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByUsername(String username);
}