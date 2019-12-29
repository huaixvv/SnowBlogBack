package com.zx.dsblog.mapper;


import com.zx.dsblog.pojo.Blog;
import com.zx.dsblog.vo.BlogVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
public interface BlogMapper extends Mapper<Blog> {

    @Select("select b.blog_id, b.blog_name, b.create_time, b.read_count, c.cata_name from blog b left join blogcata c on b.bc_id = c.cata_id")
    List<BlogVo> selectAllBlogs();

    @Update("update blog set read_count=read_count+1 where blog_id = #{blog_id}")
    void updateReadCount(@Param("blog_id") Integer blog_id);
}
