package com.bookmark.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmark.model.Bookmark;
import com.bookmark.service.Bookmarkservice;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/bookmarks")
public class Bookmarkcontroller {
	
	 private final Bookmarkservice service;

	    public Bookmarkcontroller(Bookmarkservice service) {
	        this.service = service;
	    }

	    @GetMapping
	    public List<Bookmark> getAll() {
	        return service.getAllBookmarks();
	    }

	    @PostMapping
	    public Bookmark create(@RequestBody Bookmark bookmark) {
	        return service.addBookmark(bookmark);
	    }

	    @PutMapping("/{id}")
	    public Bookmark update(@PathVariable Long id, @RequestBody Bookmark bookmark) {
	        return service.updateBookmark(id, bookmark);
	    }

	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id) {
	        service.deleteBookmark(id);
	    }
	
	

}
