package geektime.spring.springbucks.repository;

import geektime.spring.springbucks.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
