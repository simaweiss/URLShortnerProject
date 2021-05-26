package com.project.urlshortner.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.urlshortner.domain.URLPath;

@Repository
public interface URLPathRepository extends CrudRepository<URLPath, String> {

	@Query("SELECT fullUrl FROM URLPath URLPath WHERE URLPath.shortUrl = :shortUrl")
	String findfullUrlByShortlUrlParam(@Param("shortUrl") String shortUrl);

	@Query("SELECT shortUrl FROM URLPath URLPath WHERE URLPath.fullUrl = :fullUrl")
	String findShortUrlByFullUrlParam(@Param("fullUrl") String fullUrl);

	boolean existsURLPathByfullUrl(String fullUrl);
}
