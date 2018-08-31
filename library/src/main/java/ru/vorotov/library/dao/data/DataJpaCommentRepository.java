package ru.vorotov.library.dao.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.vorotov.library.model.Comment;

public interface DataJpaCommentRepository extends MongoRepository<Comment, String> {
}
