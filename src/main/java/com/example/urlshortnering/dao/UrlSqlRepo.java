package com.example.urlshortnering.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.urlshortnering.model.UrlSql;

@Repository
public interface UrlSqlRepo extends JpaRepository<UrlSql,Long> {

	Optional<UrlSql> findByLongUrl(String longUrl);
	Optional<UrlSql> findByShortUrl(String shortUrl);
}
