package com.bookmark.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookmark.model.Bookmark;
import com.bookmark.repo.Bookmarkrepo;

@Service
public class Bookmarkservice {
	
	private final Bookmarkrepo brepo;

	public Bookmarkservice(Bookmarkrepo repository) {
		this.brepo = repository;
	}

	public List<Bookmark> getAllBookmarks() {
		return brepo.findAll() ;
	}

	public Bookmark addBookmark(Bookmark bookmark) {
		return brepo.save(bookmark);
	}

	public Bookmark updateBookmark(Long id, Bookmark updatedBookmark) {
        Bookmark bookmark = brepo.findById(id).orElseThrow();
        bookmark.setTitle(updatedBookmark.getTitle());
        bookmark.setUrl(updatedBookmark.getUrl());
        return brepo.save(bookmark);
    }
	
	 public void deleteBookmark(Long id) {
	        brepo.deleteById(id);
	    }

}
