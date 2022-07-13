package nl.springms.microservice.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("Can not found user with id: " + id);
    }
}
