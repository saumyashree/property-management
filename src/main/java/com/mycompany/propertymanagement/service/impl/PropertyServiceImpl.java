package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired                 //to memory allocate
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);
        propertyRepository.save(pe);

        propertyDTO = propertyConverter.convertEntitytoDTO(pe);
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> listofProps = (List<PropertyEntity>) propertyRepository.findAll(); //typecast it so we don't get any error
        List<PropertyDTO> propList = new ArrayList<>();

        for (PropertyEntity pe : listofProps) {
            PropertyDTO dto = propertyConverter.convertEntitytoDTO(pe);
            propList.add(dto);

        }
        return propList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId); //optional is a java 8 feature which is use to null check
        PropertyDTO dto = null;
        if (optEn.isPresent()) {

            PropertyEntity pe = optEn.get();   // data from datatbase
            pe.setTitle(propertyDTO.getTitle());
            pe.setAddress(propertyDTO.getAddress());
            pe.setPrice(propertyDTO.getPrice());
            pe.setDescription(propertyDTO.getDescription());
            dto = propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId); //optional is a java 8 feature which is use to null check
        PropertyDTO dto = null;
        if (optEn.isPresent()) {

            PropertyEntity pe = optEn.get();
            pe.setDescription(propertyDTO.getDescription());
            dto = propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);
        }

        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId); //optional is a java 8 feature which is use to null check
        PropertyDTO dto = null;
        if (optEn.isPresent()) {

            PropertyEntity pe = optEn.get();
            pe.setPrice(propertyDTO.getPrice());
            dto = propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);

        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);

    }
}