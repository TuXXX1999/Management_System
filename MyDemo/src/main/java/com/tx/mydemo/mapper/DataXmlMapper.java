package com.tx.mydemo.mapper;

import com.tx.mydemo.domain.Data;
import com.tx.mydemo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;


@Mapper
@Repository
public interface DataXmlMapper {

    int add(Data data);

    int totalData(Data data);

    List<Data> selectAllByPageAndCondition(int begin, Data data1);

    List<Data> selectAllByPage(int begin);

    int updateData(Data data);

    Data selectById(Integer id);

    int deleteById(Integer id);

    List<Data> selectAllByPageAndConditionWithNull(int begin, Data data1);

    int totalDataWithNull(Data data);

    Integer totalByMonth(@Param("start") String start,@Param("end") String end);

    Integer totalByMonthById(String strStart, String strEnd, String name);
}
