package edu.kh.com.daoapplication.repository;

import edu.kh.com.daoapplication.dao.KHTProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KHTProductRepository extends JpaRepository<KHTProduct, Long> {

    //아이디를 활용해 상세보기
    KHTProduct findById(int id);
}

