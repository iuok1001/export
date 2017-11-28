package com.pers.lzl.modules.dpt.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class ShoeTreeData {

    /**
     * 型号
     */
    private String typeName;
    /**
     * 楦底样长
     */
    private Double lenXdyc;
    /**
     * 放余量
     */
    private Double lenFyl;
    /**
     * 脚趾端点部位
     */
    private Double lenJz;
    /**
     * 拇指外突点部位
     */
    private Double lenMz;
    /**
     * 小趾外突点部位
     */
    private Double lenXz;
    /**
     * 第一庶趾部位
     */
    private Double lenFirst;
    /**
     * 第五庶趾部位
     */
    private Double lenFifth;
    /**
     * 腰窝部位
     */
    private Double lenYw;
    /**
     * 踵心部位
     */
    private Double lenZx;
    /**
     * 后容差
     */
    private Double lenHrc;
    /**
     * 跖围
     */
    private Double roundTw;
    /**
     * 跗围
     */
    private Double roundFw;
    /**
     * 基本宽度
     */
    private Double widBase;
    /**
     * 拇指里宽
     */
    private Double widMz;
    /**
     * 小趾外宽
     */
    private Double widXz;
    /**
     * 第一嗻趾里宽
     */
    private Double widFirst;
    /**
     * 第五嗻趾外宽
     */
    private Double widFifth;
    /**
     * 腰窝外宽
     */
    private Double widYw;
    /**
     * 踵心全宽
     */
    private Double widZx;
    /**
     * 总前跷
     */
    private Double sizeZqr;
    /**
     * 前跷
     */
    private Double sizeQr;
    /**
     * 后跷高
     */
    private Double sizeHrg;
    /**
     * 头厚
     */
    private Double sizeTh;
    /**
     * 后跟突点高
     */
    private Double sizeHgtd;
    /**
     * 后身高
     */
    private Double sizeHsg;
    /**
     * 前掌凸度
     */
    private Double sizeQztd;
    /**
     * 低心凹度
     */
    private Double sizeDxod;
    /**
     * 踵心凸度
     */
    private Double sizeZxtd;
    /**
     * 统口宽
     */
    private Double sizeTkk;
    /**
     * 统口长
     */
    private Double sizeTkc;
    /**
     * 楦斜长
     */
    private Double sizeXxc;
}
