package com.mycompany.property_management.Controller;

import com.mycompany.property_management.DTO.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")

public class CalculatorClass {
    //http://localhost:8080/api/v1/add?num111=7.777&num222=7.777
    @GetMapping("/add")
    public Double Add(@RequestParam("num111") Double num1, @RequestParam("num222") Double num2)
    {
        return num1+num2;
    }
    @GetMapping("/Sub/{num111}/{num222}")//Map the values of url to java variables by path variable method
    //http://localhost:8080/api/v1/Sub/3.4/5.6
    public Double Sub(@PathVariable("num111") Double num1, @PathVariable("num222") Double num2)
    {
        Double result=null;
        if(num1>num2)
        {
           result=num1-num2;
        }
        else
        {
            result=num2-num1;
        }
        return result;

    }
    @GetMapping("/Div/{num3}")//Combining path variable in api request
    //http://localhost:8080/api/v1/Div/99?num111=7.77799&num222=7.77799
    public Double Div(@RequestParam("num111") Double num1,@RequestParam("num222") Double num2)
    {
        return num2/num1;
    }
    @PostMapping("/mul")
    public ResponseEntity  Multiply(@RequestBody CalculatorDTO calculatordto)
    {
        Double result=null;
        result=calculatordto.getNum1()*calculatordto.getNum2()* calculatordto.getNum3()* calculatordto.getNum4();
        ResponseEntity<Double> responseEntity=new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }

}
