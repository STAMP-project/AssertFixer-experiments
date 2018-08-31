package ru.vorotov.library.dao.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.vorotov.library.model.Book;

public interface DataJpaBookRepository extends MongoRepository<Book, String> {
}
