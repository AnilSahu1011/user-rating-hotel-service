package com.user.service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
