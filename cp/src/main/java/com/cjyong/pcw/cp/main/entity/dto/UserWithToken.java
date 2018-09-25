package com.cjyong.pcw.cp.main.entity.dto;

import com.cjyong.pcw.cp.main.entity.User;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/12/5
 * Time: 16:52
 * Description: 返回的用户信息和Token
 */
@Data
public class UserWithToken implements Serializable {
    private String jwtToken;
    private User currentUser;
    private User theOtherUser;

    public UserWithToken(String jwtToken, User currentUser, User theOtherUser) {
        this.jwtToken = jwtToken;
        this.currentUser = currentUser;
        User otherOne = new User()
                .setId(theOtherUser.getId())
                .setName(theOtherUser.getName());
        this.theOtherUser = otherOne;
    }
}
