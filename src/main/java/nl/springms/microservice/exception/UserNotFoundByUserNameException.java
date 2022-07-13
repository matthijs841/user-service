package nl.springms.microservice.exception;

public class UserNotFoundByUserNameException extends RuntimeException {

    public UserNotFoundByUserNameException(String userName) {
        super("Can not found user with username: " + userName);
    }

}
