package geektime.spring.springbucks.service;

import geektime.spring.springbucks.model.Publisher;
import geektime.spring.springbucks.repository.PublisherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Slf4j
@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public Optional<Publisher> findOnePublisher(String name){
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("name", exact().ignoreCase());
        Optional<Publisher> publisher = publisherRepository.findOne(
                Example.of(Publisher.builder().name(name).build(), exampleMatcher)
        );
        log.info("Publisher Found: " + publisher);
        return publisher;
    }
}