package com.pma.pimacpt.security.model;

import com.pma.pimacpt.model.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserCredencial implements UserDetails {
    private String userName;
    private String pass;
    private String email;
    private boolean activo;
    private Collection<? extends GrantedAuthority> authorities;
    private int idUser;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.pass;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return activo;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public UserCredencial(String userName, String pass, String email, int idUser,boolean activo, Collection<? extends GrantedAuthority> authorities) {
        this.userName = userName;
        this.pass = pass;
        this.email = email;
        this.activo = activo;
        this.authorities = authorities;
        this.idUser = idUser;
    }

    public static UserCredencial build(User user){
        List<GrantedAuthority> roles=new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(user.getCategoryUser().getNameCategory()));
        UserCredencial userCredencial=new UserCredencial(
                user.getUserName(),
                user.getPass(),
                user.getEmail(),
                user.getIdUser(),
                user.isActivo(),
                roles
        );
        return userCredencial;

    }
}
