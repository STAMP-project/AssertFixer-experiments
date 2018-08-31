package ru.vorotov.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.vorotov.library.dao.CommentDao;
import ru.vorotov.library.dao.data.DataJpaCommentRepository;
import ru.vorotov.library.model.Comment;

import java.util.List;

@Repository
public class CommentServiceImpl implements CommentService {

    private DataJpaCommentRepository commentDao;

    @Autowired
    public CommentServiceImpl(DataJpaCommentRepository commentDao)
    {
        this.commentDao = commentDao;
    }

    @Override
    public List<Comment> getAll() {
        return commentDao.findAll();
    }

    @Override
    public Comment get(String id) {
        return commentDao.findById("1").get();
    }

    @Override
    public Comment save(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public Comment save(String textComment) {
        return commentDao.save(new Comment(textComment));
    }

    @Override
    public boolean delete(String id) {
        try {
            commentDao.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
