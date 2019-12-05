package com.example.generator.base;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 * baseEntity
 * @param <T>
 */
public abstract class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "每页显示数", example = "1", required = true)
    protected Integer pageSize;

    @ApiModelProperty(value = "页码", example = "1", required = true)
    protected Integer pageNum;


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    protected abstract Serializable pkVal();
}
