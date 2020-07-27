package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeCtrl {
    @Autowired
    JobPostRepository jobPostRepository;

    @Autowired
    AuthorRepository authorRepository;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("jobs", jobPostRepository.findAll());
        return "index";
    }

    @RequestMapping("/addJobs")
    public String addJob(Model model){
        model.addAttribute("jobPost", new JobPosts());
        return "addJobs";
    }

    @PostMapping("/processJobs")
    public String processJob(@ModelAttribute JobPosts jobPosts) {
        jobPostRepository.save(jobPosts);
        return "redirect:/";
    }

    @RequestMapping("/updateAuth/{id}")
    public String updateCust(@PathVariable("id") long id, Model model){
        model.addAttribute("job", jobPostRepository.findById(id));
        return "addAuthor";
    }

    @RequestMapping("/deleteJob/{id}")
    public String deleteCust(@PathVariable("id") long id){
        jobPostRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/listJobs")
    public String listSales(Model model) {
        model.addAttribute("author", authorRepository.findAll());
        return "listJobs";
    }

    @RequestMapping("/addAuthors")
    public String addAuthor(Model model){
        model.addAttribute("author", new Author());
        model.addAttribute("authors", jobPostRepository.findAll());
        return "addAuthors";
    }

    @PostMapping("/processAuthors")
    public String processSale(@Valid Author author, BindingResult result) {

        if(result.hasErrors()){
            return "addAuthor";
        }
        else{
            authorRepository.save(author);
            return "redirect:/";
        }}


}
