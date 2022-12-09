package com.dans.multi.pro.test.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Table;

import java.io.Serializable;


@Entity(name = "users")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    private int id;
    private String email;
    private String password;
    private String name;
    private String phone;
}
