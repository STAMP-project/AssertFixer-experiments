package com.cryptoeagle.service;

import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.exception.IcoNotFoundException;
import com.cryptoeagle.repository.IcoRepository;
import com.cryptoeagle.service.abst.IcoService;
import com.cryptoeagle.service.abst.RestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;


@Service
@EnableScheduling
@Slf4j
public class IcoServiceImpl implements IcoService {

    IcoRepository repository;

    RestService service;

    @Autowired
    public void IcoServiceImpl(IcoRepository repository, RestService service) {
        this.repository = repository;
        this.service = service;
    }

    public List<Ico> getAll() {
        return repository.getAll();
    }

    @Override
    @Transactional
    public void save(List<Ico> icos) {
        log.info("get all icos");
        for (Ico ico : icos) {
            repository.save(ico);
        }
    }

    @Override
    public List<Ico> getUpcoming() {
        log.info("get upcoming icos");
        List<Ico> icos = repository.getUpcoming();
        if (icos.size() == 0) {
            log.error("IcoNotFoundException");
            throw new IcoNotFoundException("Upcoming ICO not found");
        }
        return icos;
    }


    @Override
    public List<Ico> getFinished() {
        log.info("get finished icos");
        List<Ico> icos = repository.getFinished();
        if (icos.size() == 0) {
            log.error("IcoNotFoundException");
            throw new IcoNotFoundException("finished ICO not found");
        }
        return icos;
    }

    @Override
    public List<Ico> getActive() {
        log.info("get getActive icos");
        List<Ico> icos = repository.getActive();
        if (icos.size() == 0) {
            log.error("IcoNotFoundException");
            throw new IcoNotFoundException("finished ICO not found");
        }
        return icos;
    }

    @Override
    @Transactional()
    public Ico getById(int id) {
        log.info("get  ico by id :" + id);
        try {
            return repository.getById(id);
        } catch (Exception e) {
            log.error("IcoNotFoundException");
            throw new IcoNotFoundException(e.getMessage() + " Ico id : " + id);
        }
    }

    @Override
    public Ico getByName(String name) {
        log.info("get  ico by name :" + name);
        try {
            return repository.getByName(name);
        } catch (Exception e) {
            log.error("IcoNotFoundException");
            throw new IcoNotFoundException(e.getMessage() + " Ico name : " + name);
        }
    }

    @Override
    @Transactional
    public void update() {
        deletAll();
        for (int i = 1; i < 2; i++) {
            List<Ico> page = service.getIcoWithDataByPage(i);
            save(page);
        }

    }

    @Override
    @Transactional
    public void deletAll() {
        log.info("get  delete all");
        List<Ico> all = getAll();
        for (Ico ico : all) {
            repository.delete(ico);
        }

    }
}
