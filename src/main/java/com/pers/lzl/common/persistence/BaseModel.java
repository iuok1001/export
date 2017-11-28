package com.pers.lzl.common.persistence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class BaseModel {

    private String id;
    protected String remarks;	// 备注
    protected String createByName;	// 创建者
    protected Date createDate;	// 创建日期
    protected String updateByName;	// 更新者
    protected Date updateDate;	// 更新日期
    protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）

}
