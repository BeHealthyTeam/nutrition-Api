package com.nutrition.api.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Objects;


public class UserAuth {

    public static UserAuthDTO get() {

        var auth = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        var tokenAttributes = auth.getTokenAttributes();

//        var name = tokenAttributes.get("name");
        var email = tokenAttributes.get("email");
//        var code = isNull(email) ? tokenAttributes.get("preferred_username") : email;
//        var roles = getRoles(tokenAttributes);

//        log.info("nome: {}, email: {}, code: {},roles: {}", name, email, code, join(",", roles));

        return UserAuthDTO.builder()
                .email(Objects.toString(email))
                .build();
    }
}
