package ru.vorotov.library.dao.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.vorotov.library.model.Author;

public interface DataJpaAuthorRepository extends MongoRepository<Author, String> {
}
