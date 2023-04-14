package shop.mtcoding.docapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.docapp.model.post.Post;

import java.util.Arrays;
import java.util.List;

@RestController
public class PostController {

    @PostMapping("/posts")
    public ResponseEntity<?> save(@RequestBody Post post) {
        // 서비스.회원가입(user);
        Post postEntity = Post.builder()
                .id(1)
                .title("제목1")
                .content("내용1")
                .build();

        return new ResponseEntity<>(postEntity, HttpStatus.CREATED);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        // 서비스.회원정보보기(id);
        Post postEntity = Post.builder()
                .id(1)
                .title("제목1")
                .content("내용1")
                .build();

        return new ResponseEntity<>(postEntity, HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<?> findAll() {
        // 서비스.회원전체보기();
        Post postEntity1 = Post.builder()
                .id(1)
                .title("제목1")
                .content("내용1")
                .build();

        Post postEntity2 = Post.builder()
                .id(2)
                .title("제목2")
                .content("내용2")
                .build();

        List<Post> posts = Arrays.asList(postEntity1, postEntity2);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}