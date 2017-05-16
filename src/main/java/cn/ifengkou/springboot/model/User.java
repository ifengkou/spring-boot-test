package cn.ifengkou.springboot.model;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.util.Date;

/**
 * Description:
 *
 * @author shenlongguang
 * @date: 2017/5/16 下午1:58.
 */
public class User {
    private long id;
    @ApiParam(value = "名称", required = true)
    private String name;
    private int age;
    @ApiModelProperty(hidden = true)
    private boolean isDeleted;
    @ApiModelProperty(dataType = "java.util.Date")
    private Date createTime;
    @ApiModelProperty(dataType = "java.util.Date")
    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
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
}
