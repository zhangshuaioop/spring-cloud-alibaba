package com.example.commoncomponets.entity.consume.pm;

import com.example.commoncomponets.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "用户信息")
public class SysUsers extends BaseEntity {
    @ApiModelProperty(value = "id", example = "1", required = true)
    private Long id;

    @ApiModelProperty(value = "用户名", example = "1", required = true)
    private String username;

    @ApiModelProperty(value = "年龄", example = "1", required = true)
    private Integer age;

    @ApiModelProperty(value = "手机号", example = "1", required = true)
    private String mobile;

    @ApiModelProperty(value = "是否删除", example = "1", required = true)
    private Boolean flagDelete;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createTime;

    @ApiModelProperty(value = "更新时间", example = "1", required = true)
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Boolean getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(Boolean flagDelete) {
        this.flagDelete = flagDelete;
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
        return "SysUsers{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", mobile='" + mobile + '\'' +
                ", flagDelete=" + flagDelete +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}