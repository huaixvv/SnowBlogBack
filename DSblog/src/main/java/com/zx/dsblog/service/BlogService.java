package com.zx.dsblog.service;

import com.zx.dsblog.mapper.BlogMapper;
import com.zx.dsblog.pojo.Blog;
import com.zx.dsblog.vo.BlogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogMapper blogMapper;

    //获取所有博客
    public List<BlogVo> listBlog(){
         return blogMapper.selectAllBlogs();
    }

    //根据id获取博客详情
    public Blog getBlog(Integer id){
        blogMapper.updateReadCount(id);     //阅读次数++
        Blog b = new Blog();
        b.setBlogId(id);
        Blog blog = blogMapper.selectOne(b);
        return blog;
    }

    //分类获取博客列表
    public List<Blog> getBlogsByCataId(Integer cataid){
        Blog blog = new Blog();
        blog.setBcId(cataid);
        List<Blog> blogs = blogMapper.select(blog);
        return blogs;
    }
}
