package com.my.SpringSecutity.SpringRest;

import com.my.SpringSecutity.SpringRest.Error.ErrorMessage;
import com.my.SpringSecutity.SpringRest.Error.ErrorNotCreated;
import com.my.SpringSecutity.SpringRest.Error.ErrorValid;
import com.my.SpringSecutity.SpringRest.ServerApi.ServerApiRest;
import com.my.SpringSecutity.models.UserModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    private final ServerApiRest serverApiRest;

    @Autowired
    public MyRestController(ServerApiRest serverApiRest) {
        this.serverApiRest = serverApiRest;
    }

    @GetMapping()
    public List<UserModels> findAll() {
        //List<UserModels> list=serverApiRest.findAll();
        return serverApiRest.findAll();
    }

    @GetMapping("/{id}")
    public UserModels findId(@PathVariable("id") int id) {

        return serverApiRest.findId(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus>create(@RequestBody UserModels models, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder stringBuilder=new StringBuilder();
            List<FieldError>fieldErrors=bindingResult.getFieldErrors();
            for(FieldError error:fieldErrors){
                stringBuilder.append(error.getField())
                        .append("-").append(error.getDefaultMessage())
                        .append(";");
            }
            throw  new ErrorNotCreated(stringBuilder.toString());
        }
        serverApiRest.save(models);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessage>createdError(ErrorNotCreated e){
        ErrorMessage errorMessage=new ErrorMessage(
                "Not created objrct",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> Hendlername(ErrorValid errorValid) {
        ErrorMessage errorMessage = new ErrorMessage(
                "Not found id such a value",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
