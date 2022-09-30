package com.api.userdept.userdept.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DepartmentDTO {

    @NotBlank
    private String name;

}
