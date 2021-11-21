package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.repository.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDB userDB;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDB.save(user);
    }

    @Override
    public String encrypt(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public List<UserModel> getAll() {
        return userDB.findAll();
    }

    @Override
    public UserModel getById(String id) {
        Optional<UserModel> user = userDB.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    @Override
    public void deleteUser(UserModel user) {
        userDB.delete(user);
    }

    @Override
    public UserModel getByUsername(String uname) {
        return userDB.findByUsername(uname);
    }

    @Override
    public boolean cekEmaul(String email) {
        List<UserModel> user = userDB.findAll();
        for (UserModel u: user) {
            if (u.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }
}
