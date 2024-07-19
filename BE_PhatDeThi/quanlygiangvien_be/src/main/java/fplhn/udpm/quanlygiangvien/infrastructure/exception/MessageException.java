package fplhn.udpm.quanlygiangvien.infrastructure.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageException extends RuntimeException{

    private String message;

    public MessageException(String message){
        this.message = message;
    }
}
