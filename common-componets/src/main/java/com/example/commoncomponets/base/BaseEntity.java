package com.example.commoncomponets.base;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 * baseEntity
 * @param <T>
 */
public abstract class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "每页显示数", example = "1", required = true)
    protected Integer pageSize = 20;

    @ApiModelProperty(value = "页码", example = "1", required = true)
    protected Integer pageNo = 1;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

}
