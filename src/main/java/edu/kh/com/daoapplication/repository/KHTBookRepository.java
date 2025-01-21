package edu.kh.com.daoapplication.repository;

import edu.kh.com.daoapplication.entity.KHTBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KHTBookRepository extends JpaRepository<KHTBook, Long> {

    //아이디로 책 찾기
    KHTBook findById(int id);

}
