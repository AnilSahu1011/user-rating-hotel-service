package com.user.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "micro_users")
public class User {

    @Id
    private String userId;

    private String name;

    private String email;

    private String about;

    @Transient //We are not storing this field into the Db
    private List<Rating> ratings;
}
