package nl.springms.microservice.repository;

import nl.springms.microservice.exception.UserNotFoundByUserNameException;
import nl.springms.microservice.exception.UserNotFoundException;
import nl.springms.microservice.model.UserEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class CustomUserRepositoryImpl implements CustomUserRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public UserEntity customFindMethod(Long id) {
        try {
            return (UserEntity) entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception ex) {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public UserEntity customFindByUserName(String userName) {
        try {
            return (UserEntity) entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.userName = :userName")
                    .setParameter("userName", userName)
                    .getSingleResult();
        } catch (Exception ex) {
            throw new UserNotFoundByUserNameException(userName);
        }
    }
}
