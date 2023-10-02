package com.mri.transactional.entity;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Data
public class Student {

    @Id
    private Long id;
    private String name;
    private String mobile;
    private String address;
}
