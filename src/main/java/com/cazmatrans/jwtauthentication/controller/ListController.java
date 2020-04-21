package com.cazmatrans.jwtauthentication.controller;

import com.cazmatrans.jwtauthentication.repository.ListRepository;
import com.cazmatrans.jwtauthentication.model.List;
import com.cazmatrans.jwtauthentication.repository.RoleRepository;
import com.cazmatrans.news.exception.ListNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/list")
public class ListController {

    @Autowired
    ListRepository listRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping(value="/getPage")
    public Page<List> getPage(Pageable pageable) {
        return listRepository.findAll(pageable);
    }

    //Get a List
    @GetMapping(value="/{id}")
    public List getListById(@PathVariable(value = "id") Long listId) throws ListNotFoundException {
        return listRepository.findById(listId)
                .orElseThrow(() -> new ListNotFoundException(listId));
    }

    //Create a new List
    @PostMapping(value="/createList")
    public List createList(@Valid @RequestBody List list) {
        return listRepository.save(list);
    }

    //Update List
    @PutMapping(value="/{id}")
    public List updateList(@PathVariable(value = "id") Long listId,
                           @Valid @RequestBody List listDetails) throws ListNotFoundException {

        List list = listRepository.findById(listId)
                .orElseThrow(() -> new ListNotFoundException(listId));

        list.setImage(listDetails.getImage());
        list.setNewsHref(listDetails.getNewsHref());
        list.setActive(listDetails.getActive());
        list.setPrice(listDetails.getPrice());
        list.setTitle(listDetails.getTitle());

        List updateList = listRepository.save(list);

        return updateList;
    }

    // Delete List
    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> deleteList(@PathVariable(value = "id") Long listId) throws ListNotFoundException {
        List list = listRepository.findById(listId)
                .orElseThrow(() -> new ListNotFoundException(listId));
        listRepository.delete(list);

        return ResponseEntity.ok().build();
    }
}

