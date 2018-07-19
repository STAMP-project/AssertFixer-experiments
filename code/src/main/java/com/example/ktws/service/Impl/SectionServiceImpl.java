package com.example.ktws.service.Impl;

import com.example.ktws.domain.Course;
import com.example.ktws.domain.Section;
import com.example.ktws.domain.User;
import com.example.ktws.repository.SectionRepository;
import com.example.ktws.service.CourseService;
import com.example.ktws.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private CourseService courseService;

    @Override
    public Section addNewSection(Timestamp dateTime, Course course) {
        Section s = new Section();
        s.setDatetime(dateTime);
        s.setCourse(course);
        return sectionRepository.save(s);
    }

    @Override
    public Iterable<Section> getSectionsByCourse(Course course) {
        return sectionRepository.findByCourse(course);
    }

    @Override
    public Iterable<Section> getSectionsByUser(User user) {
        List<Section> result = new ArrayList<>();
        List<Course> courses = (ArrayList<Course>) courseService.getCoursesByUser(user);
        for (Course c : courses) {
            Set<Section> sections = c.getSections();
            result.addAll(sections);
        }
        return result;
    }

    @Override
    public Optional<Section> findById(Long id) {
        return sectionRepository.findById(id);
    }
}
