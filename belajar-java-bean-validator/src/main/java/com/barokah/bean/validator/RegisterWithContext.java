package com.barokah.bean.validator;

import com.barokah.bean.validator.annotatons.CheckPasswordWithContext;
import jakarta.validation.constraints.NotBlank;

@CheckPasswordWithContext(message="password does not match")
public class RegisterWithContext {
    @NotBlank(message = "user name can not be blank")
    private String userName;
    @NotBlank(message = "password can not be blank")
    private String password;
    @NotBlank(message = "retype password can not be blank")
    private String retypePassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }

    @Override
    public String toString() {
        return "Register{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", retypePassword='" + retypePassword + '\'' +
                '}';
    }
}
