package com.sostraik1903.distroprofes_v3.service;

import com.sostraik1903.distroprofes_v3.entity.RoleVO;
import com.sostraik1903.distroprofes_v3.entity.UserVO;
import com.sostraik1903.distroprofes_v3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = false)
    public void create(UserVO user) {
        PasswordEncoder password = new BCryptPasswordEncoder();
        String hashPassword = password.encode(user.getPassword());
        user.setPassword(hashPassword);

        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(UserVO user) {
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserVO findById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public Collection<UserVO> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserVO findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Collection<Object[]> findAllWhitRole() {
        return userRepository.findAllWhitRole();
    }

    // BASIC AUTH
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO dbUser = findByUsername(username);

        if(dbUser == null) {
            throw new UsernameNotFoundException("El usuario no existe");
        }

        Collection<GrantedAuthority> roles = new ArrayList<>();

        for(RoleVO role: dbUser.getItemsRole()){
            roles.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
        }


        return new User(username, dbUser.getPassword(), roles);
    }


}
