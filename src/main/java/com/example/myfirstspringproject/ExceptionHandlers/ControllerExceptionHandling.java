package com.example.myfirstspringproject.ExceptionHandlers;

import com.example.myfirstspringproject.DTO.ExceptionDto;
import com.example.myfirstspringproject.DTO.ProductNotFoundExceptionDto;
import com.example.myfirstspringproject.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandling {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handlerArithmeticException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something went wrong");
        exceptionDto.setResolution("Nothing can be done");
        ResponseEntity<ExceptionDto> response=new ResponseEntity<>(exceptionDto,HttpStatus.BAD_REQUEST);
        return response;
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<Void> ArrayOutOfBoundsException(){
        ResponseEntity<Void> response=new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handlerProductNotFoundException(ProductNotFoundException productNotFoundException
    ){
           ProductNotFoundExceptionDto dto = new ProductNotFoundExceptionDto();
           dto.setMessage("Product Not found with given "+ productNotFoundException.getId());
           return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }


}
