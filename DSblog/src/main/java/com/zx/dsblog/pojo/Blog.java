package com.zx.dsblog.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "blog")
public class Blog {

    @Id
    private Integer blogId;
    private String blogName;
    private String blogAuther;
    private String blogContent;
    private Date createTime;
    private Date lastEditTime;
    private Integer bcId;
    private Integer readCount;
}
