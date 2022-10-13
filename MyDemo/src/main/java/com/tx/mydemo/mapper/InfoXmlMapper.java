package com.tx.mydemo.mapper;


import com.tx.mydemo.domain.Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author TuXXX
 */
@Mapper
@Repository
public interface InfoXmlMapper {
    public List<Info> selectAll();
    int add(Info info);
    int deleteById(int id);
    Info selectById(Integer id);

    int update(Info info);

    List<Info> selectAllByPageAndCondition(
            @Param("begin") int begin,
            @Param("name")String name,
            @Param("phone")String phone,
            @Param("type")String type
    );

    int totalInfo(Info info);

    List<Info> selectAllByPage(int begin);

    List<Info> selectAllByPageAndCondition(int begin,Info info);

}
