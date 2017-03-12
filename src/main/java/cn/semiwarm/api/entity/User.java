package cn.semiwarm.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：用户实体类
 * <p>
 * Created by alibct on 2017/2/23.
 */
public class User implements Serializable {
    private Long userId; // 用户ID
    private String userName; // 用户名称
    private String userPhone; // 用户手机号
    private String password; // 密码
    private Boolean status; // 账号是否可用->默认可用
    private Date createAt; // 用户创建时间

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", createAt=" + createAt +
                '}';
    }
}
