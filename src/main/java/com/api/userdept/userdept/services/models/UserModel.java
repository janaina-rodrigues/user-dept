package com.api.userdept.userdept.services.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_USER")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Length(min = 5, max = 200)
    @Column(length = 200, nullable = false)
    private String name;

    @Length(min = 5, max = 50)
    @Column(length = 50, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentModel department;

}
