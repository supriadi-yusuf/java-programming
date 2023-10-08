package com.barokah.bean.validator;

import com.barokah.bean.validator.annotatons.CheckPasswordParam;
import jakarta.validation.constraints.NotBlank;

public class UserService {
    @CheckPasswordParam(passwordPosition=1, retypePasswordPosition=2, message = "password is not consistent")
    public void register(@NotBlank(message = "userName must not blank") String userName,
                         @NotBlank(message = "password must not blank") String password,
                         @NotBlank(message = "retype password must not blank") String retypePassword){

    }
}

