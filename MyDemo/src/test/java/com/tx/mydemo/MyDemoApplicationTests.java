package com.tx.mydemo;

import com.tx.mydemo.domain.Info;
import com.tx.mydemo.mapper.InfoXmlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyDemoApplicationTests {

    @Autowired
//    private InfoMapper infoMapper;

    private InfoXmlMapper infoXmlMapper;


//    @Test
//    public void testFindAll(){
//        List<Info> all = infoMapper.selectAll();
//        System.out.println(all);
//    }

    @Test
    public void testFindAll2(){
        List<Info> all = infoXmlMapper.selectAll();
        System.out.println(all);
        int i = 0;
        System.out.println(i);

    }

}
