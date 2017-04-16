package com.demo.data.domain.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * 基础实体模型
 * 1. 创建时间
 * 2. 更新时间
 *
 * @author kxw
 * @version 2017/1/11 14:57
 */
@MappedSuperclass
public class BaseDomain {

    @Column(name = "CREATED_TIME",
            insertable = false,
            updatable = false,
            columnDefinition = "COMMENT '数据创建时间'")
    private Timestamp createTime;

    @Column(name = "UPDATED_TIME",
            insertable = false,
            updatable = false,
            columnDefinition = "COMMENT '数据更新时间'")
    private Timestamp updateTime;

    @Column(name = "IS_DELETED",
            columnDefinition = "COMMENT '数据是否业务删除'")
    private Boolean isDeleted = false;

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
