package top.lxyi.train.business.req;

        import java.util.Date;
        import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProgammerSaveReq {

    /**
    * 
    */
    @NotNull(message = "【】不能为空")
    private Long id;

    /**
    * 
    */
    private String account;

    /**
    * 
    */
    private String mobile;

    /**
    * 
    */
    private String nickname;

    /**
    * 
    */
    private String avatar;

    /**
    * 
    */
    private String description;

    /**
    * 
    */
    private String homepage;

    /**
    * 
    */
    private String skill;

    /**
    * 
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    /**
    * 
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date updateTime;

    public Long getid() {
    return id;
    }

    public void set﻿id(Long id) {
    this.id = id;
    }

    public String getAccount() {
    return account;
    }

    public void setAccount(String account) {
    this.account = account;
    }

    public String getMobile() {
    return mobile;
    }

    public void setMobile(String mobile) {
    this.mobile = mobile;
    }

    public String getNickname() {
    return nickname;
    }

    public void setNickname(String nickname) {
    this.nickname = nickname;
    }

    public String getAvatar() {
    return avatar;
    }

    public void setAvatar(String avatar) {
    this.avatar = avatar;
    }

    public String getDescription() {
    return description;
    }

    public void setDescription(String description) {
    this.description = description;
    }

    public String getHomepage() {
    return homepage;
    }

    public void setHomepage(String homepage) {
    this.homepage = homepage;
    }

    public String getSkill() {
    return skill;
    }

    public void setSkill(String skill) {
    this.skill = skill;
    }

    public Date getCreateTime() {
    return createTime;
    }

    public void setCreateTime(Date createTime) {
    this.createTime = createTime;
    }

    public Date getUpdateTime() {
    return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
    }

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(getClass().getSimpleName());
sb.append(" [");
sb.append("Hash = ").append(hashCode());
    sb.append(", id=").append(id);
    sb.append(", account=").append(account);
    sb.append(", mobile=").append(mobile);
    sb.append(", nickname=").append(nickname);
    sb.append(", avatar=").append(avatar);
    sb.append(", description=").append(description);
    sb.append(", homepage=").append(homepage);
    sb.append(", skill=").append(skill);
    sb.append(", createTime=").append(createTime);
    sb.append(", updateTime=").append(updateTime);
sb.append("]");
return sb.toString();
}
}