package com.zx.dsblog.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Blog {

    private Integer blogId;
    private String blogName;
    private String blogAuther;
    private String blogContent;
    private Date createTime;
    private Date lastEditTime;
    private Integer bcId;
}
