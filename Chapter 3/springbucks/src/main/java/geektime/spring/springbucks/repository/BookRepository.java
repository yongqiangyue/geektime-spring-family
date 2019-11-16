package geektime.spring.springbucks.repository;

import geektime.spring.springbucks.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
