package FlashBrain_Backend.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExceptionUserHandler {

    @ExceptionHandler(ResourceUserException.class)
    public ResponseEntity<ResponseError> exceptionUserHandler(ResourceUserException e, HttpServletRequest request){

        String error = "Error ao tentar acessar ou manipular dados do usuário.";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ResponseError response = new ResponseError(Instant.now(),
                status.value(),
                error,
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(response);
    }
}
