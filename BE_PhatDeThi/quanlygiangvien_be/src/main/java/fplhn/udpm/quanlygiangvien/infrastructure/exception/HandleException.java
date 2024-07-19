package fplhn.udpm.quanlygiangvien.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandleException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> exceptionHandler(MethodArgumentNotValidException ex){
        Map<String,String> valuesMap=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String key=((FieldError) error).getField();
            String value=error.getDefaultMessage();
            valuesMap.put(key,value);
        });
        return new ResponseEntity<>(valuesMap,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MessageException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> messageExceptionHandler(MessageException messageException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageException.getMessage());
    }

    @ExceptionHandler(KeyValueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> keyValueExceptionHandler(KeyValueException keyValueException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(keyValueException.getErrors());
    }
}
