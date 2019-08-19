package com.demo.homepage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>基本的用户信息</h1>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private Long id;

    private String username;

    private String email;

    public static UserInfo invalid() {
        return new UserInfo(-1L, "", "");
    }
}
