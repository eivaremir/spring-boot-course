package com.in28minutes.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.in28minutes.rest.webservices.restfulwebservices.post.Post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@JsonFilter("Filter_props")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, message="name should have at least 2 chars")
    private String name;

    @Past
    private Date bdate;

    @OneToMany(mappedBy ="user")
    private List<Post> post;

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }
    protected User(){}
    public User(Integer id, String name, Date bdate) {
        super();
        this.id = id;
        this.name = name;
        this.bdate = bdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
