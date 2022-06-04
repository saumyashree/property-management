package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity convertDTOtoEntity(UserDTO userDTO){
        UserEntity userEntity=new UserEntity();
        userEntity.setOwnerName(userDTO.getOwnerName());
        userEntity.setOwnerEmail(userDTO.getOwnerEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setPhone(userDTO.getPhone());
return userEntity;
    }
    public UserDTO convertEntityToDTO(UserEntity userEntity){
      UserDTO userDTO= new UserDTO();
      userDTO.setId(userEntity.getId());
        userDTO.setOwnerName(userEntity.getOwnerName());
        userDTO.setOwnerEmail(userEntity.getOwnerEmail());
       userDTO.setPhone(userEntity.getPhone());
        return userDTO;


    }




}
