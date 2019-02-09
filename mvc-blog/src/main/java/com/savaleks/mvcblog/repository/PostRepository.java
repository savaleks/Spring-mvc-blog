package com.savaleks.mvcblog.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.savaleks.mvcblog.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

	@Query("SELECT p FROM Post p LEFT JOIN FETCH p.author ORDER BY p.date DESC")
	List<Post> findLatest5Posts(Pageable pageable);
}
