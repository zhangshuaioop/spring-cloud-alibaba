package com.example.commoncomponets.entity.provide.pm;

import com.example.commoncomponets.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "权限信息")
public class SysAuthority extends BaseEntity {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Long id;

    @ApiModelProperty(value = "权限名称", example = "1", required = true)
    private String name;

    @ApiModelProperty(value = "用户id", example = "1", required = true)
    private Integer sysUsersId;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSysUsersId() {
        return sysUsersId;
    }

    public void setSysUsersId(Integer sysUsersId) {
        this.sysUsersId = sysUsersId;
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
        return "SysAuthority{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sysUsersId=" + sysUsersId +
                ", flagDelete=" + flagDelete +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}