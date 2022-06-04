package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController                                  //controller
@RequestMapping("/api/v1")
public class PropertyController {
    //RESTfull API is just mapping of a url to a java class function
    //localhost:8081/api/v1/properties/hello/ -->this url mapped to a function that is what RESTful web services
    @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")
    public String sayHello() {

        return "hello";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {
        propertyDTO = propertyService.saveProperty(propertyDTO);

        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/properties")          // Rest End points
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        List<PropertyDTO> propertyList = propertyService.getAllProperties();
        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
        return responseEntity;
    }


@PutMapping("/properties/{propertyId}")                     //fully update
    public  ResponseEntity<PropertyDTO>  updateProperty(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyId){
      propertyDTO =  propertyService.updateProperty(propertyDTO,propertyId);
    ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
    return responseEntity;

    }


    @PatchMapping("/properties/update-description/{propertyId}")                                           //partial update
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO,@PathVariable  Long propertyId){
      propertyDTO =  propertyService.updatePropertyDescription(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
 }

    @PatchMapping("/properties/update-price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyDTO =  propertyService.updatePropertyPrice(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }
@DeleteMapping("/properties/{propertyId}")
public ResponseEntity deleteProperty(@PathVariable Long propertyId){
        propertyService.deleteProperty(propertyId);
    ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
return responseEntity;
}




}
