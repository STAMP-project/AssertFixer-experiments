package ru.vorotov.library.dao.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.vorotov.library.model.Genre;

public interface DataJpaGenreRepository extends MongoRepository<Genre, String> {
}
