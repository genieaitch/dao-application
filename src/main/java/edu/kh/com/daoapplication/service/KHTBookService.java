package edu.kh.com.daoapplication.service;

import edu.kh.com.daoapplication.entity.KHTBook;
import edu.kh.com.daoapplication.repository.KHTBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class KHTBookService {
    @Autowired
    private KHTBookRepository khtBookRepository;

    // 모든 책 조회
    public List<KHTBook> findAll() {
        return khtBookRepository.findAll();
    }

    //아이디로 책 조회
    public KHTBook findById(int id) {
        return khtBookRepository.findById(id);
    }

    //책 저장
    public KHTBook save(KHTBook book) {
        return khtBookRepository.save(book);
    }
}
