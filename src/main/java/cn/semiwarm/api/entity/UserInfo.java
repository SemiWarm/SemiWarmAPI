package cn.semiwarm.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息类
 * Created by alibct on 2017/3/12.
 */
public class UserInfo implements Serializable{
    private Long userId;
    private String payPassword;
    private String userSex;
    private Date userBirthday;
    private String userPhoto;
    private Integer userLevel;
    private String userEmail;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", payPassword='" + payPassword + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday=" + userBirthday +
                ", userPhoto='" + userPhoto + '\'' +
                ", userLevel=" + userLevel +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}