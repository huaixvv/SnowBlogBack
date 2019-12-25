package com.zx.dsblog.controller;

import com.zx.dsblog.pojo.Blog;
import com.zx.dsblog.result.Result;
import com.zx.dsblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/all")
    @ResponseBody
    public Result<List> getBlogAll(){

        List<Blog> bloglist = blogService.listBlog();
        System.out.println(bloglist);
        return Result.success(bloglist);
    }

    @GetMapping("/deatil")
    @ResponseBody
    public Result<Blog> getBlogById(@RequestParam("blogId") Integer blogId){
        Blog blog = blogService.getBlog(blogId);
        System.out.println(blog);
        return Result.success(blog);
    }
}