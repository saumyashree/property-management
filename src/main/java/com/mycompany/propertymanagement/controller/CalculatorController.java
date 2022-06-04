package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.CalculatorDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")//this is a class level mapping of url to a controller class
public class CalculatorController {

//http://localhost:8081/api/v1/calculator/add?num1=6.5&num2=3.5
    @GetMapping("/add/{num3}")//method level mapping of url to a controller function
    public Double add(@RequestParam("num1") Double num1,@RequestParam("num2") Double  num2,
                      @PathVariable("num3") Double num3){
        return num1+num2;
    }

    @GetMapping("/subtract/{num1}/{num2}")//map the value of url to java variable by path variable method
    public Double subtract(@PathVariable Double num1,@PathVariable("num2") Double num2){
      Double result=null;
      if (num1>num2){
          result=num1-num2;
      }else {
          result =num2-num1;
        }
      return result;
    }

@PostMapping("/mul")
    public Double multiply(@RequestBody CalculatorDTO calculatorDTO){
        Double result=null;
        result= calculatorDTO.getNum1()*calculatorDTO.getNum2()*calculatorDTO.getNum3()*calculatorDTO.getNum4();
       return result;
    }

}
