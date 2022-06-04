package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {

    PropertyDTO saveProperty(PropertyDTO propertyDTO);   // in interface by defalut all method are public and abstract

    List<PropertyDTO> getAllProperties();    //for get all property

    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);  //for updating a property

    PropertyDTO updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, Long propertyId);

    PropertyDTO updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, Long propertyId);

    void deleteProperty(Long propertyId);


}