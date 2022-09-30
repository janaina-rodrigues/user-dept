package com.api.userdept.userdept.services;

import com.api.userdept.userdept.services.models.UserModel;
import com.api.userdept.userdept.repositories.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Data
@Service
public class UserService {

   final  UserRepository userRepository;
   @Transactional
   public UserModel save(UserModel userModel) {
      return userRepository.save(userModel);
   }

   public List<UserModel>  findAll() {
      return userRepository.findAll();
   }

   public Optional<UserModel> findById(Long id) {
      return userRepository.findById(id);
   }
   @Transactional
   public void delete(UserModel userModel) {
      userRepository.delete(userModel);
   }
}
