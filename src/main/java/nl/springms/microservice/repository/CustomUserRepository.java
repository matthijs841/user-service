package nl.springms.microservice.repository;

import nl.springms.microservice.model.UserEntity;


public interface CustomUserRepository {
    UserEntity customFindMethod(Long id);

    UserEntity customFindByUserName(String userName);
}
