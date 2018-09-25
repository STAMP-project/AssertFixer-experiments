package com.cjyong.pcw.cp.main.dao;

import com.cjyong.pcw.cp.main.entity.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2018/9/11
 * Time: 16:54
 * Description:
 */
@Repository
public interface PaperRepository extends JpaRepository<Paper, Integer> {

    /**
     * 根据smallType获取对象
     *
     * @param smallType
     * @return
     */
    Paper findFirstBySmallType(String smallType);

    /**
     *
     *
     * @param type
     * @return
     */
    List<Paper> findByTypeOrderByIdAsc(int type);

    /**
     * 获取所有的对象
     *
     * @param start
     * @return
     */
    List<Paper> findByIdAfterOrderByIdAsc(int start);
}
