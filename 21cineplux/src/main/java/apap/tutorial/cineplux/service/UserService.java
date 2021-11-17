package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    List<UserModel> getAll();
}
