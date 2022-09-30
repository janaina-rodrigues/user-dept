package com.api.userdept.userdept.services.models;

import lombok.*;
import org.hibernate.validator.constraints.Length;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_DEPARTMENT")
public class DepartmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Length(min = 5, max = 200)
    @Column(length = 200, nullable = false)
    private String name;
}
