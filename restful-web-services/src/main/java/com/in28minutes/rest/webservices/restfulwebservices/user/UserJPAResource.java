package com.in28minutes.rest.webservices.restfulwebservices.user;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.in28minutes.rest.webservices.restfulwebservices.post.Post;
import com.in28minutes.rest.webservices.restfulwebservices.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJPAResource {

    @Autowired
    private UserDaoService service;

    @Autowired
    private UserRepository repository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/jpa/users")
    public MappingJacksonValue  retrieveAllUsers(){
    //public List<User> retrieveAllUsers(){
        MappingJacksonValue mapping = new MappingJacksonValue(repository.findAll());
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name");
        FilterProvider filters = new SimpleFilterProvider().addFilter("Filter_props",filter);
        mapping.setFilters(filters);
        return mapping ;
    }

    @GetMapping("/jpa/users/{id}")
    public MappingJacksonValue retrieveUser(@PathVariable Integer id){
        Optional<User> user = repository.findById(id);

        if(!user.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }

        /*EntityModel<User> model = EntityModel.of(user.get());
        WebMvcLinkBuilder linkToUsers = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        model.add(linkToUsers.withRel("all-users"));
        return model;*/

        MappingJacksonValue mapping = new MappingJacksonValue(user);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name");
        FilterProvider filters = new SimpleFilterProvider().addFilter("Filter_props",filter);
        mapping.setFilters(filters);
        return mapping ;

    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
       repository.deleteById(id);

    }

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = repository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveAllUserPosts(@PathVariable int id){
        Optional<User> user = repository.findById(id);

        if(!user.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }

        return user.get().getPost();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable int id,@Valid @RequestBody Post post){
        Optional<User> userOptional = repository.findById(id);

        if(!userOptional.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }

        User user = userOptional.get();
        post.setUser(user);
        postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
