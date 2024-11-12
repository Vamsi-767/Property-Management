package com.mycompany.property_management.Repository;

import com.mycompany.property_management.DTO.Entity.PropertyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyRepository extends CrudRepository<PropertyEntity,Long> {
    //u can either use Query or findby...
    //@Query("SELECT p FROM PropertyEntity p WHERE p.UserEntity.id=:userId")
    List<PropertyEntity>findAllByUserEntityId(@Param("userid") Long userid);
}
