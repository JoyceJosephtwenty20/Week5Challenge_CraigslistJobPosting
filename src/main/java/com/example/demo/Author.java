package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String phoneNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<JobPosts> jobPosts;

    public Author() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getphoneNumber() {
        return phoneNumber;
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public Set<JobPosts> getJobPosts() {
        return jobPosts;
    }

    public void setJobPosts(Set<JobPosts> jobPosts) {
        this.jobPosts = jobPosts;
    }

    public void addcust(JobPosts cust){
        if(this.jobPosts ==null){
            this.jobPosts =new HashSet<JobPosts>();
        }
        this.jobPosts.add(cust);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
