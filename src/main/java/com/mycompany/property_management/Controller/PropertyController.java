package com.mycompany.property_management.Controller;

import com.mycompany.property_management.DTO.PropertyDTO;
import com.mycompany.property_management.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
//RESTFULApi is just a mapping of a url to javaclass function

public class PropertyController {
    @Value("$ {spring.datasource.url}")
    private String Dummy;
    @Autowired
    private PropertyService propertyService;
    @GetMapping("/hello")
    public String gethello()
    {
        return "HelloVamsi";
    }

    @PostMapping("/properties")
    public ResponseEntity saveproperty(@RequestBody PropertyDTO propertyDTO)
    {
        propertyDTO=propertyService.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity=new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }
    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getallproperties()
    {
        System.out.println(Dummy);
        List<PropertyDTO> propertyList=propertyService.getallproperties();
        ResponseEntity<List<PropertyDTO>> responseEntity=new ResponseEntity<>(propertyList,HttpStatus.OK);
        return responseEntity;
    }
    @PutMapping("/properties/{propertyid}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyid) {
        propertyDTO = propertyService.updateProperty(propertyDTO,propertyid);
        ResponseEntity<PropertyDTO> responseEntity=new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }
    @PatchMapping("/properties/update-description/{propertyid}")
    public ResponseEntity<PropertyDTO> updateDescription(@RequestBody PropertyDTO  propertyDTO,@PathVariable Long propertyid)
    {
        propertyDTO = propertyService.updateDescription(propertyDTO,propertyid);
        ResponseEntity<PropertyDTO> responseEntity=new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }
    @PatchMapping("/properties/update-price/{propertyid}")
    public ResponseEntity<PropertyDTO> updatePrice(@RequestBody PropertyDTO  propertyDTO,@PathVariable Long propertyid)
    {
        propertyDTO = propertyService.updatePrice(propertyDTO,propertyid);
        ResponseEntity<PropertyDTO> responseEntity=new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("/properties/{propertyid}")
    public  ResponseEntity<Void> deleteProperty(@PathVariable Long propertyid)
    {
        propertyService.deleteProperty(propertyid);
        ResponseEntity<Void> responseEntity=new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return responseEntity;
    }
}
