package com.itnkc.search;

import com.itnkc.search.entity.Book;
import com.itnkc.search.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.Optional;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/23 15:06
 */
@SpringBootTest
public class EsTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void saveOrUpdate() {
        Book book = new Book();
        book.setId("4");
        book.setName("狂人日记");
        book.setAuthor("鲁迅");
        book.setCreateDate(new Date());
        book.setContent("鲁迅书籍");
        bookRepository.save(book);
    }

    @Test
    public void delete() {
        bookRepository.deleteById("3");
    }

    /**
     * 查询所有
     */
    @Test
    public void findAll() {
        Iterable<Book> books = bookRepository.findAll();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    /**
     * 根据id查询
     */
    @Test
    public void findById() {
        Optional<Book> byId = bookRepository.findById("1");
        Book book = byId.get();
        System.out.println(book);
    }

    @Test
    public void order() {
        Iterable<Book> books = bookRepository.findAll(Sort.by(Sort.Order.asc("createDate")));
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void getAuthor() {
        Iterable<Book> books = bookRepository.findByAuthor("鲁迅");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void order2() {
        Iterable<Book> books = bookRepository.findByContentAndName("鲁迅书籍", "呐喊");
        for (Book book : books) {
            System.out.println(book);
        }
    }

}
