package edu.kh.com.daoapplication.controller;

import edu.kh.com.daoapplication.dao.KHTProduct;
import edu.kh.com.daoapplication.dao.KHTUser;
import edu.kh.com.daoapplication.service.KHTProductService;
import edu.kh.com.daoapplication.service.KHTUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api") //맨 앞에 공통으로 들어갈 url api 명칭 작성
public class ApiController {

    @Autowired
    private KHTUserService khtUserService;

    @Autowired
    private KHTProductService khtProductService;

    @GetMapping("/users") // /api/users
    public List<KHTUser> findAllUsers() {
        List<KHTUser> users = khtUserService.findAll();
        log.info("findAll users: {}", users);
        return users;
    }

    @PostMapping("/save") // /api/save
    public KHTUser saveUser(@RequestBody KHTUser khtUser) {
        return khtUserService.save(khtUser);
    }

    @GetMapping("/products") // /api/products
    public List<KHTProduct> findAllProducts() {
        return khtProductService.findAll();
    }

    @GetMapping("/products/{id}")
    public KHTProduct findProductById(@PathVariable int id) {
        KHTProduct khtProduct = khtProductService.findById(id);
        log.info(khtProduct.toString());
        return khtProductService.findById(id);
    }

    @PostMapping("/saveProduct") // /api/saveProduct
    public KHTProduct saveProduct(@RequestBody KHTProduct khtProduct) {
        return khtProductService.save(khtProduct);
    }

    /**
     * 
     * @RequestParam 으로 전달받은 id 값을
     * URLSearchParams = URL 주소에서 parameters(파라미터들)을 search 검색해서
     * urlParams 라는 변수 이름에 ? 뒤에 오는 키=값 을 모두 담아둠
     * urlParams 에서 원하는 키의 값을get해서 가져옴
     * id라는 변수 이름에 키에 해당하는 값을 저장
     * 
     * const urlParams = new URLSearchParams(window.location.search);
     * const id = urlParams.get('id');
     * @param id 는 get('id'로 가져온 값을 활용해서 ajax로 db에서 id값에 해당하는 데이터를 가져오기
     * @return
     */
    @GetMapping("/user/{id}")
    public KHTUser findById(@PathVariable int id) {
        KHTUser khtUser = khtUserService.findById(id);
        log.info(khtUser.toString());
        return khtUserService.findById(id); // 가져온 데이터가 있든 없든 html에 전달
    }

}