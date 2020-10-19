package com.spring.blog.controller;

import com.spring.blog.model.Post;
import com.spring.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts() {
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = blogService.findAll();
        mv.addObject("posts", posts);
        return mv;
    }

    @ResquestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView(viewName: "postDetails");
        Postposts = codeblogService.findById(id);
        mv.addObject( attributeName: 'post', post);
        return mv;
    }

    @ResquestMapping(value = "/novopost", method = RequestMethod.GET)
    public String getPostForm(){
        return "postForm";
    }

    @ResquestMapping(value = "/novopost", method = RequestMethod.POST)
    public String salvarPost(@Valid Post post, BindingResults result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "redirect:/novopost";
        }
        post.setData(LocalDate.now());
        BlogService.save(post);
        return "redirect:/posts";
    }

}
