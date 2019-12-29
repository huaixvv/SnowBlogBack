package com.zx.dsblog.controller;

import com.github.pagehelper.PageException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.dsblog.pojo.Blog;
import com.zx.dsblog.result.CodeMsg;
import com.zx.dsblog.result.Result;
import com.zx.dsblog.service.BlogService;
import com.zx.dsblog.vo.BlogVo;
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
    public Result<PageInfo> getBlogAll(@RequestParam("page") Integer page){

        PageHelper.startPage(page,20);
        List<BlogVo> bloglist = blogService.listBlog();
        System.out.println(bloglist);
        PageInfo<BlogVo> pageInfo = new PageInfo<>(bloglist);
//        System.out.println(pageInfo);
        return Result.success(pageInfo);
    }

    @GetMapping("/deatil")
    @ResponseBody
    public Result<Blog> getBlogById(@RequestParam("blogId") Integer blogId){
        Blog blog = blogService.getBlog(blogId);
//        System.out.println(blog);
        return Result.success(blog);
    }

    @GetMapping("/catagory")
    @ResponseBody
    public Result<PageInfo> getBlogListByCataId(@RequestParam("catagoryId") Integer catagoryId,
                                                     @RequestParam("page") Integer page){

        if (catagoryId == 0){
            return getBlogAll(page);
        }else{
            PageHelper.startPage(page, 20);
            List<Blog> bloglist = blogService.getBlogsByCataId(catagoryId);
            if (bloglist.size() == 0){
                return Result.error(CodeMsg.BLOG_EMPTY);
            }
            PageInfo<Blog> pageInfo = new PageInfo<>(bloglist);
//            System.out.println(2);
            return Result.success(pageInfo);
        }
    }
}