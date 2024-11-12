package com.mycompany.property_management.Service.Impl;

import com.mycompany.property_management.Converter.PropertyConverter;
import com.mycompany.property_management.DTO.Entity.PropertyEntity;
import com.mycompany.property_management.DTO.Entity.UserEntity;
import com.mycompany.property_management.DTO.PropertyDTO;
import com.mycompany.property_management.Repository.PropertyRepository;
import com.mycompany.property_management.Repository.UserRepository;
import com.mycompany.property_management.Service.PropertyService;
import com.mycompany.property_management.exception.BusinessException;
import com.mycompany.property_management.exception.ErrorModel;
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
    @Value("${spring.datasource.driverClassName}")
    private String DriverName;
    @Autowired
    private PropertyRepository propertyrepository;
    @Autowired
    private PropertyConverter propertyConverter;
    @Autowired
    private UserRepository userRepository;
    @Override
    public PropertyDTO saveproperty(PropertyDTO propertyDTO) {
        Optional<UserEntity> opue= userRepository.findById(propertyDTO.getUserid());
        if (opue.isPresent()) {
            PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);
            pe.setUserEntity(opue.get());
            pe = propertyrepository.save(pe);
            propertyDTO = propertyConverter.convertEntitytoDTO(pe);

        }
        else {
            List<ErrorModel> errorModelList=new ArrayList<>();
            ErrorModel errorModel=new ErrorModel();
            errorModel.setCode("USER_NOT_FOUND");
            errorModel.setMessage("User doesn't exists");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getallproperties() {
        System.out.println("This is inside Service"+Dummy);
        System.out.println("This is inside Service + DriverName"+DriverName);
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
    public List<PropertyDTO> getallpropertiesByUser(Long userid) {

        List<PropertyEntity> listofallpropertiesuser= (List<PropertyEntity>) propertyrepository.findAllByUserEntityId(userid);
        List<PropertyDTO>Proplist=new ArrayList<>();
        for(PropertyEntity pe: listofallpropertiesuser)
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
