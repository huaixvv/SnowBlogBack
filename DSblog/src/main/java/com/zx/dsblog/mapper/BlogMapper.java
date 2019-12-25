package com.zx.dsblog.mapper;


import com.zx.dsblog.pojo.Blog;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
public interface BlogMapper extends Mapper<Blog> {

//    @Select("select * from blog")
//    public List<Blog> listBlog();
//
}
