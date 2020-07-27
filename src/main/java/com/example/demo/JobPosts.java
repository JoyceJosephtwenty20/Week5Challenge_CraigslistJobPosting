package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class JobPosts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String date;

    @ManyToMany(mappedBy = "jobPosts",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER)
    private Set<Author> authors;

    public JobPosts() {
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

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
