package com.mycompany.property_management.DTO.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="PROPERTY_TABLE")
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "PROPERTY_TITLE",nullable = false,length = 200)
    private String title;
    private String description;
    private Double price;
    private String  address;
    @ManyToOne(fetch = FetchType.LAZY)//It will not fetch user data will only fetch property ; if User info also req the use Eager
    @JoinColumn(name = "USER_ID",nullable = false)
    private UserEntity userEntity;
}
