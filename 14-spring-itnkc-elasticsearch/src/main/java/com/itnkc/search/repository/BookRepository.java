package com.itnkc.search.repository;

import com.itnkc.search.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/23 15:05
 */
public interface BookRepository extends ElasticsearchRepository<Book, String> {

    Iterable<Book> findByAuthor(String keyword);

    Iterable<Book> findByContentAndName(String content, String name);
}
