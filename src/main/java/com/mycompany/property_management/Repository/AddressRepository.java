package com.mycompany.property_management.Repository;

import com.mycompany.property_management.DTO.Entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressEntity,Long> {
}
