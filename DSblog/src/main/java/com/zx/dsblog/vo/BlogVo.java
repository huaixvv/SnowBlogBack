package com.zx.dsblog.vo;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
public class BlogVo {

    private Integer blogId;
    private String blogName;
    private Date createTime;
    private Integer readCount;
    private String cataName;

}
