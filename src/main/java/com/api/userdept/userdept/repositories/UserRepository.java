package com.api.userdept.userdept.repositories;

import com.api.userdept.userdept.services.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
