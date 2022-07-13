package nl.springms.microservice;

import nl.springms.microservice.exception.UserNotFoundException;
import nl.springms.microservice.model.UserEntity;
import nl.springms.microservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomRepositoryUnitTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void customFindShouldReturnUser(){
        UserEntity testUserEntity = new UserEntity();
        testUserEntity.setUserName("Test");
        testUserEntity.setFirstName("Test");
        testUserEntity.setLastName("Test");

        UserEntity savedUserEntity = userRepository.save(testUserEntity);

        assertNotNull(userRepository.customFindMethod(testUserEntity.getId()));
        assertEquals(savedUserEntity.getUserName(), userRepository.customFindMethod(testUserEntity.getId()).getUserName());

    }

    @Test
    public void customFindShouldReturnException(){
        assertThrows(UserNotFoundException.class, () -> userRepository.customFindMethod(110L));
    }

}
