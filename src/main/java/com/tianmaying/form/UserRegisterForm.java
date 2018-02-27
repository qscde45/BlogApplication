package com.tianmaying.form;

import com.tianmaying.model.User;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;

/**
 * Created by Hao on 2/26/18.
 */
public class UserRegisterForm {

    @Size(min = 6, max = 30, message = "Username should be 6-30 characters long")
    private String name;

    @Size(min = 6, max = 30)
    private String password;

    @Email
    private String email;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public User ToUser () {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        return user;
    }

}
