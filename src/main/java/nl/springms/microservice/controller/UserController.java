package nl.springms.microservice.controller;

import nl.springms.microservice.model.UserDTO;
import nl.springms.microservice.model.UserEntity;
import nl.springms.microservice.repository.UserRepository;
import nl.springms.microservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping ("/users")
    List<UserDTO> findAll(){
        return userService.findAllUsers();
    }

    @GetMapping ("/user/{id}")
    UserDTO findById(@PathVariable Long id){
        return userService.customFindMethod(id);
    }

    @PostMapping("/user")
    UserDTO save(@RequestBody UserDTO userDTO) {return userService.save(userDTO);}

    @DeleteMapping("/user/{userName}")
    void delete(@PathVariable String userName) {userService.delete(userName);
    }

}
