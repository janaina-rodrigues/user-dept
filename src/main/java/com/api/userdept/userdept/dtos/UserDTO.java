package com.api.userdept.userdept.dtos;

import com.api.userdept.userdept.services.models.DepartmentModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotNull
    private DepartmentModel department;
}
