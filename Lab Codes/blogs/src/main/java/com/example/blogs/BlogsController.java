package com.example.blogs;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/blog")
public class BlogsController {
    List<Blog> blogs;

     BlogsController() {
        blogs = new ArrayList<>();
        blogs.add(new Blog("My First Blog", "Isha Savaliya"));
        blogs.add(new Blog("My Second Blog", "Isha Savaliya"));
    }

    @GetMapping("/")
    public String getGreetings() {
        return "Hi there!!";
    }
    @GetMapping("/welcome/{name}")
    public String getWelcomeMsg(@PathVariable("name") String name) {
        return "Welcome, " + name.toUpperCase();
    }

    @GetMapping("/bloginfo")
    public Blog getStudentInfo() {
        return new Blog("My First Blog", "Isha Savaliya");
    } 


    @PostMapping("/add")
    public String postMethodName(@RequestParam("title") String title, @RequestParam("author") String author) {
            blogs.add(new Blog(title, author));
            return "New Blog Added,total count is: " + blogs.size();
    } 
    
    @GetMapping("/fetchall")
    public List<Blog> getFetchBlogs() {
        return blogs;
    }
    
}
