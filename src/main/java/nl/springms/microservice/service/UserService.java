package nl.springms.microservice.service;

import nl.springms.microservice.exception.ConstraintViolationException;
import nl.springms.microservice.model.UserDTO;
import nl.springms.microservice.model.UserEntity;
import nl.springms.microservice.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAllUsers(){
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(u -> new UserDTO(u.getUserName(), u.getFirstName(), u.getLastName())).toList();
    }

    public UserDTO customFindMethod(Long id) {
        UserEntity userEntity = userRepository.customFindMethod(id);
        return new UserDTO(userEntity.getUserName(), userEntity.getFirstName(), userEntity.getLastName());
    }

    public UserDTO save(UserDTO userDTO){
        try{
            UserEntity userEntity = new UserEntity(userDTO.getUserName(), userDTO.getFirstName(), userDTO.getLastName());
            userRepository.save(userEntity);
            return new UserDTO(userEntity.getUserName(), userEntity.getFirstName(), userDTO.getLastName());
        } catch (Exception e){
            throw new ConstraintViolationException(e.getMessage());
        }
    }

    public void delete (String userName){
        UserEntity userEntity = userRepository.customFindByUserName(userName);
        userRepository.deleteById(userEntity.getId());
    }
}
