package com.mycompany.property_management.DTO.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="ADDRESS_TABLE")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Streetname;
    private Long Aptno;
    private String city;
    private String Country;


    @OneToOne
    @JoinColumn(name = "USER_ID",nullable = false)
    private UserEntity userEntity;

}
