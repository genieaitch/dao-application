package edu.kh.com.daoapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/product")
    public String getProduct() {
        return "product";
    }

    /**
     * @Request=요청해서 가져옴 param=매개변수, 파라미터에 해당하는("id") 값을
     *            ? 물음표 뒤에 오는 키=값 형태로 값을 가져옴
     *            /user?id=아이디에 해당하는 값을 가져와서
     *            /user?id=1 번호로 이동
     *
     * @param id 는 userDetail(=유저 상세보기) 페이지에 유저 번호로 해당하는 유저 상세정보를
     *              userDetail.html 에서 번호에 해당하는 유저를 볼 수 있도록 설정하는 parameter
     * @return
     */
    @GetMapping("/user")
    public String getUser(@RequestParam("id") int id) {
        return "userDetail";
    }

    @GetMapping("/productDetail")
    public String getProduct(@RequestParam("id") int id) {
        return "productDetail";
    }

    // 📚 책 목록 보기
    @GetMapping("/books")
    public String getBooks() {
        return "books";
    }

    // 📖 특정 책 보기 (ID로 조회)
    @GetMapping("/bookDetail")
    public String getBookById(@RequestParam("id") int id) {
        return "bookDetail";
    }

    // 📝 책 추가하기
    @GetMapping("/bookSave")
    public String getBookAdd() {
        return "newBooks";
    }

    @GetMapping("/inputEmail")
    public String inputEmail() {
        return "inputEmail"; //inputEmail.html 템플릿으로 접속하는 주소 설정
    }
}
