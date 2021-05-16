package org.yjy.com.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.yjy.com.entity.Memo;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass(){
        System.out.println(memoRepository.getClass().getName());
    }

    //100개의 새로운 Memo객체를 생성하고 memoRepository이용해 insert 테스트
    @Test
    public void testInsertDummies(){

        IntStream.rangeClosed(1,100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Sample..."+i).build();
            memoRepository.save(memo);
        });
    }

    //findById 를 이용한 조회
    @Test
    public void testSelect(){

        Long mno = 100L;

        Optional<Memo> result = memoRepository.findById(mno);

        System.out.println("=================");

        if(result.isPresent()){
            Memo memo = result.get();
            System.out.println(memo);
        }
    }

    //getOne 을 이용한 조회
    @Transactional
    @Test
    public void testSelect2(){

        Long mno = 100L;

        Memo memo = memoRepository.getOne(mno);

        System.out.println("1================== ");

        System.out.println(memo);
    }


    //update
    @Test
    public void testUpdate(){
        Memo memo = Memo.builder().mno(100L).memoText("Update......1").build();
        System.out.println("1================== ");
        memoRepository.save(memo);
        System.out.println("2================== ");
    }

    //delete
    @Test
    public void testDelete(){

        Long mno = 100L;

        memoRepository.deleteById(mno);
    }
}
