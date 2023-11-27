package com.nutrition.api.utils;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserAuthDTO {
    private String email;
}
