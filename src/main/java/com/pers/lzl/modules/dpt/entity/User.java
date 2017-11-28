package com.pers.lzl.modules.dpt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pers.lzl.common.persistence.BaseModel;
import com.pers.lzl.common.utils.excel.annotation.ExcelField;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Setter
@ToString
@EqualsAndHashCode
public class User extends BaseModel{

    private static final long serialVersionUID = 1L;
    private Integer age; //年龄
    private Float seniority; //工龄
    private Double gradePoint; //等级
    private String company;	// 归属公司
    private String office;	// 归属部门
    private String loginName;// 登录名
    private String password;// 密码
    private String no;		// 工号
    private String name;	// 姓名
    private String email;	// 邮箱
    private String phone;	// 电话
    private String mobile;	// 手机
    private String userType;// 用户类型
    private String loginIp;	// 最后登陆IP
    private Date loginDate;	// 最后登陆日期
    private String loginFlag;	// 是否允许登陆
    private String photo;	// 头像
    private String oldLoginName;// 原登录名
    private String newPassword;	// 新密码
    private String oldLoginIp;	// 上次登陆IP
    private Date oldLoginDate;	// 上次登陆日期

    @ExcelField(title="ID", type=0, align=2, sort=10)
    public String getId() {
        return super.getId();
    }

    @ExcelField(title="备注", align=2, sort=20)
    public String getRemarks() {
        return remarks;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelField(title="创建者", align=0, sort=30)
    public String getCreateByName() {
        return createByName;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelField(title="创建日期", align=3, sort=40)
    public Date getCreateDate() {
        return createDate;
    }

    @ExcelField(title="更新者", align=2, sort=50)
    public String getUpdateByName() {
        return updateByName;
    }

    @ExcelField(title="更新日期", align=1, sort=60)
    public Date getUpdateDate() {
        return updateDate;
    }

    @ExcelField(title="删除标记", align=0, sort=70)
    public String getDelFlag() {
        return delFlag;
    }

    @ExcelField(title="年龄", align=2, sort=70)
    public Integer getAge() {
        return age;
    }

    @ExcelField(title="工龄", align=0, sort=80)
    public Float getSeniority() {
        return seniority;
    }

    @ExcelField(title="等级", align=1, sort=90)
    public Double getGradePoint() {
        return gradePoint;
    }

    @ExcelField(title="归属公司**曹尼玛", align=2, sort=100)
    public String getCompany() {
        return company;
    }

    @ExcelField(title="归属部门", align=3, sort=110)
    public String getOffice() {
        return office;
    }

    @ExcelField(title="登录名", align=2, sort=120)
    public String getLoginName() {
        return loginName;
    }

    @ExcelField(title="密码", align=2, sort=130)
    public String getPassword() {
        return password;
    }

    @ExcelField(title="工号", align=2, sort=140)
    public String getNo() {
        return no;
    }

    @ExcelField(title="姓名", align=3, sort=150)
    public String getName() {
        return name;
    }

    @ExcelField(title="邮箱", align=2, sort=160)
    public String getEmail() {
        return email;
    }

    @ExcelField(title="电话", align=2, sort=170)
    public String getPhone() {
        return phone;
    }

    @ExcelField(title="手机", align=2, sort=180)
    public String getMobile() {
        return mobile;
    }

    @ExcelField(title="用户类型", align=2, sort=190)
    public String getUserType() {
        return userType;
    }

    @ExcelField(title="最后登陆IP", align=2, sort=200)
    public String getLoginIp() {
        return loginIp;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelField(title="最后登陆日期", align=2, sort=210)
    public Date getLoginDate() {
        return loginDate;
    }

    @ExcelField(title="是否允许登陆", align=2, sort=220)
    public String getLoginFlag() {
        return loginFlag;
    }

    @ExcelField(title="头像", align=2, sort=230)
    public String getPhoto() {
        return photo;
    }

    @ExcelField(title="原登录名", align=2, sort=240)
    public String getOldLoginName() {
        return oldLoginName;
    }

    @ExcelField(title="新密码", align=2, sort=250)
    public String getNewPassword() {
        return newPassword;
    }


    @ExcelField(title="上次登陆IP", type=0, align=1, sort=260)
    public String getOldLoginIp() {
        return oldLoginIp;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelField(title="上次登陆日期", align=2, sort=270)
    public Date getOldLoginDate() {
        return oldLoginDate;
    }
}


