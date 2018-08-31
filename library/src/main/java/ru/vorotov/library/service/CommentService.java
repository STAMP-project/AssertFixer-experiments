package ru.vorotov.library.service;

import ru.vorotov.library.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAll();

    Comment get(String id);

    Comment save(Comment comment);

    Comment save(String textComment);

    boolean delete(String id);
}
