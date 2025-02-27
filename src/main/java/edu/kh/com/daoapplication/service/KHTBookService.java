package edu.kh.com.daoapplication.service;

import edu.kh.com.daoapplication.model.entity.KHTBook;
import edu.kh.com.daoapplication.repository.KHTBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class KHTBookService {
    @Autowired
    private KHTBookRepository khtBookRepository;

    @Value("${upload-img}") //application.properties 에 작성한 이미지 경로 가져옴
    private String uploadImg; //가져온 경로는 uploadImg 공간 안에 담아줌


    // 모든 책 조회
    public List<KHTBook> findAll() {
        return khtBookRepository.findAll();
    }

    //아이디로 책 조회
    public KHTBook findById(int id) {
        return khtBookRepository.findById(id);
    }

    /**
     * 글자 타입의 데이터만 저장할 때 사용하는 방법
     * @param book
     * @return
    //책 저장
    public KHTBook save(KHTBook book) {
        return khtBookRepository.save(book);
    }
    */

    public KHTBook save(String title, String author, String genre, MultipartFile file)  {

        // 0. 저장할 파일 이름 불러오기
        // A 유저 = 이미지이름 = 다운로드.jpg  B 유저 = 이미지이름 = 다운로드.jpg
        // 1. 현재시간 추가    2. UUID 랜덤 이름 명칭생성
        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();

//                                  경로 + 파일명칭
        try {
            File saveFile = new File(uploadImg, filename);
            // 1. 이미지 저장하기
            file.transferTo(saveFile);
        } catch (IOException e) {
            System.out.println("이미지 저장 실패!");
        }

        // 2. 이미지 경로 String 타입으로 저장하기
        KHTBook book = new KHTBook();
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setImagePath("/images/" + filename);

        return khtBookRepository.save(book);
    }

}
