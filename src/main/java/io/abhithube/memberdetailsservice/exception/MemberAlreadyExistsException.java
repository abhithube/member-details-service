package io.abhithube.memberdetailsservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class MemberAlreadyExistsException extends RuntimeException {
    public MemberAlreadyExistsException(String msg) {
        super(msg);
    }
}
