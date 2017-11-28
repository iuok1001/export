package com.pers.lzl.modules.dpt.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class ShoeTreeDataVo {
    private String id;
    private String name;
    private String type;
    private List<ShoeTreeData> shoeTreeDataList;
}

