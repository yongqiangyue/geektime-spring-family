package geektime.spring.springbucks.service;

import geektime.spring.springbucks.model.Book;
import geektime.spring.springbucks.model.Publisher;
import geektime.spring.springbucks.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;

@Slf4j
@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book createBook(String bookName, Publisher...publisher){
        Book book = Book.builder()
                .name(bookName)
                .publishers(new HashSet<Publisher>(Arrays.asList(publisher)))
                .build();
        Book saved = bookRepository.save(book);
        log.info("new book: " + saved);
        return saved;
    }
}
