package com.mycompany.property_management.Converter;

import com.mycompany.property_management.DTO.Entity.PropertyEntity;
import com.mycompany.property_management.DTO.PropertyDTO;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO)
    {
        PropertyEntity pe= new PropertyEntity();
        pe.setTitle(propertyDTO.getTitle());
        pe.setAddress(propertyDTO.getAddress());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setPrice(propertyDTO.getPrice());
        pe.setDescription(propertyDTO.getDescription());
        return pe;

    }
    public PropertyDTO convertEntitytoDTO(PropertyEntity propertyEntity) {
        PropertyDTO pd = new PropertyDTO();
        pd.setTitle(propertyEntity.getTitle());
        pd.setAddress(propertyEntity.getAddress());
        pd.setOwnerEmail(propertyEntity.getOwnerEmail());
        pd.setOwnerName(propertyEntity.getOwnerName());
        pd.setPrice(propertyEntity.getPrice());
        pd.setDescription(propertyEntity.getDescription());
        pd.setId(propertyEntity.getId());
        return pd;
    }
}
