package com.cazmatrans.jwtauthentication.controller;

import com.cazmatrans.jwtauthentication.repository.NewsRepository;
import com.cazmatrans.jwtauthentication.repository.RoleRepository;
import com.cazmatrans.jwtauthentication.model.News;
import com.cazmatrans.news.exception.NewsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping(value="/getPage")
    public Page<News> getPage(Pageable pageable) {
        return newsRepository.findAll(pageable);
    }

    //Get a Single News
    @GetMapping(value="/{id}")
    public News getNewsById(@PathVariable(value = "id") Long newsId) throws NewsNotFoundException {
        return newsRepository.findById(newsId)
                .orElseThrow(() -> new NewsNotFoundException(newsId));
    }

    //Create a new News
    @PostMapping(value="/createNews")
    public News createNews(@Valid @RequestBody News news) {
        return newsRepository.save(news);
    }

    //Update News
    @PutMapping(value="/{id}")
    public News updateNews(@PathVariable(value = "id") Long newsId,
                              @Valid @RequestBody News newsDetails) throws NewsNotFoundException {

        News news = newsRepository.findById(newsId)
                .orElseThrow(() -> new NewsNotFoundException(newsId));

        news.setHref(newsDetails.getHref());
        news.setTitle(newsDetails.getTitle());
        news.setActive(newsDetails.getActive());
        news.setContext(newsDetails.getContext());

        News updateNews = newsRepository.save(news);

        return updateNews;
    }

    // Delete News
    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable(value = "id") Long newsId) throws NewsNotFoundException {
        News news = newsRepository.findById(newsId)
                .orElseThrow(() -> new NewsNotFoundException(newsId));
        newsRepository.delete(news);

        return ResponseEntity.ok().build();
    }
}