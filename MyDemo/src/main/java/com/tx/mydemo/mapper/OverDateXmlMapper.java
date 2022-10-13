package com.tx.mydemo.mapper;


import com.tx.mydemo.domain.OverDate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author TuXXX
 */
@Mapper
@Repository
public interface OverDateXmlMapper {
    public List<OverDate> selectAll();
    int add(OverDate overDate);
    int deleteById(int id);
    OverDate selectById(Integer id);

    int update(OverDate overDate);

    List<OverDate> selectAllByPageAndCondition(
            @Param("begin") int begin,
            @Param("name")String name,
            @Param("phone")String phone,
            @Param("time")String Time
    );

    int totalInfo(OverDate overDate);

    List<OverDate> selectAllByPage(int begin);

    List<OverDate> selectAllByPageAndCondition(int begin,OverDate overDate);

    int checkOverDate();
}
