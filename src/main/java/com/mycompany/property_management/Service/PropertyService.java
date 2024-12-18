package com.mycompany.property_management.Service;

import com.mycompany.property_management.DTO.PropertyDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {
    PropertyDTO saveproperty(PropertyDTO propertyDTO);
    List<PropertyDTO> getallproperties();
    List<PropertyDTO> getallpropertiesByUser(Long userid);
    PropertyDTO updateProperty(PropertyDTO propertyDTO,Long propertyid);
    PropertyDTO updateDescription(@RequestBody PropertyDTO  propertyDTO, @PathVariable Long propertyid);
    PropertyDTO updatePrice(@RequestBody PropertyDTO  propertyDTO,@PathVariable Long properptyid);
    void deleteProperty(Long propertyid);
}
