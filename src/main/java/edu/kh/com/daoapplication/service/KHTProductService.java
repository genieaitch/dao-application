package edu.kh.com.daoapplication.service;

import edu.kh.com.daoapplication.dao.KHTProduct;
import edu.kh.com.daoapplication.repository.KHTProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KHTProductService {

    @Autowired
    private KHTProductRepository khtProductRepository;

    // 모든 상품 조회
    public List<KHTProduct> findAll() {
        return khtProductRepository.findAll();
    }

    // 상품 저장
    public KHTProduct save(KHTProduct product) {
        return khtProductRepository.save(product);
    }
}
