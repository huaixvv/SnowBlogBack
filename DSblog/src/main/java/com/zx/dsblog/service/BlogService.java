package com.zx.dsblog.service;

import com.zx.dsblog.mapper.BlogMapper;
import com.zx.dsblog.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogMapper blogMapper;

    public List<Blog> listBlog(){
        return blogMapper.selectAll();
    }

    public Blog getBlog(Integer id){
        Blog b = new Blog();
        b.setBlogId(id);
        Blog blog = blogMapper.selectOne(b);
        return blog;
    }
}
