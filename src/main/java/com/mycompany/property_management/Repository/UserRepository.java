package com.mycompany.property_management.Repository;
import com.mycompany.property_management.DTO.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
}
