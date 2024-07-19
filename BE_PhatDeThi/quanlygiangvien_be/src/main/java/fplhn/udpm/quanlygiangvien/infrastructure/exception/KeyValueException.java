package fplhn.udpm.quanlygiangvien.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KeyValueException extends RuntimeException{

    private Map<String,String> errors = new HashMap<>();

}
