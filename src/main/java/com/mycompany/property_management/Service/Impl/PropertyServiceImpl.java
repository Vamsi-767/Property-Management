package com.mycompany.property_management.Service.Impl;

import com.mycompany.property_management.Converter.PropertyConverter;
import com.mycompany.property_management.DTO.Entity.PropertyEntity;
import com.mycompany.property_management.DTO.PropertyDTO;
import com.mycompany.property_management.Repository.PropertyRepository;
import com.mycompany.property_management.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Value("$ {spring.datasource.url}")
    private String Dummy;
    @Autowired
    private PropertyRepository propertyrepository;
    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity pe=propertyConverter.convertDTOtoEntity(propertyDTO);
        pe=propertyrepository.save(pe);
        propertyDTO=propertyConverter.convertEntitytoDTO(pe);
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getallproperties() {
        System.out.println("This is inside Service"+Dummy);
        List<PropertyEntity> listofallproperties= (List<PropertyEntity>) propertyrepository.findAll();
        List<PropertyDTO>Proplist=new ArrayList<>();
        for(PropertyEntity pe: listofallproperties)
        {
            PropertyDTO dto=propertyConverter.convertEntitytoDTO(pe);
            Proplist.add(dto);
        }
        return Proplist;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyid) {
        PropertyDTO dto=null;
       Optional<PropertyEntity> opEN= propertyrepository.findById(propertyid);
       if(opEN.isPresent())
       {
           PropertyEntity pe=opEN.get();//data from database
           pe.setTitle(propertyDTO.getTitle());
           pe.setAddress(propertyDTO.getAddress());
           pe.setOwnerEmail(propertyDTO.getOwnerEmail());
           pe.setOwnerName(propertyDTO.getOwnerName());
           pe.setPrice(propertyDTO.getPrice());
           pe.setDescription(propertyDTO.getDescription());
           dto=propertyConverter.convertEntitytoDTO(pe);
           propertyrepository.save(pe);
       }

        return dto;
    }

    @Override
    public PropertyDTO updateDescription(PropertyDTO propertyDTO, Long propertyid) {
        PropertyDTO dto=null;
        Optional<PropertyEntity> opEN= propertyrepository.findById(propertyid);
        if(opEN.isPresent())
        {
            PropertyEntity pe=opEN.get();//data from database
            pe.setDescription(propertyDTO.getDescription());
            dto=propertyConverter.convertEntitytoDTO(pe);
            propertyrepository.save(pe);
        }

        return dto;
    }

    @Override
    public PropertyDTO updatePrice(PropertyDTO propertyDTO, Long propertyid) {
        PropertyDTO dto=null;
        Optional<PropertyEntity> opEN= propertyrepository.findById(propertyid);
        if(opEN.isPresent())
        {
            PropertyEntity pe=opEN.get();//data from database
            pe.setPrice(propertyDTO.getPrice());
            dto=propertyConverter.convertEntitytoDTO(pe);
            propertyrepository.save(pe);
        }

        return dto;
    }

    @Override
    public void deleteProperty(Long propertyid) {
        propertyrepository.deleteById(propertyid);
    }
}
