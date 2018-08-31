package ru.vorotov.library.dao;

import ru.vorotov.library.model.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> getAll();

    Comment get(String id);

    Comment save(Comment comment);

    boolean delete(String id);

}
