package com.bookmark.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmark.model.Bookmark;

public interface Bookmarkrepo extends JpaRepository<Bookmark, Long>{
  
	
	
}
