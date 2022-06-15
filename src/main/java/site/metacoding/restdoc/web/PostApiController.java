package site.metacoding.restdoc.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import site.metacoding.restdoc.domain.Post;

// save -> post
// deleteById -> delete
// updateById -> put
// findById -> get
// findAll -> get
@RequestMapping("/api")
@RestController
public class PostApiController {

    @PostMapping("/post")
    public ResponseEntity<?> save(@RequestBody Post post) {
        // 서비스.회원가입(user);
        Post postEntity = Post.builder()
                .id(1)
                .title("제목1")
                .content("내용1")
                .build();

        return new ResponseEntity<>(postEntity, HttpStatus.CREATED);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        // 서비스.회원정보보기(id);
        Post postEntity = Post.builder()
                .id(1)
                .title("제목1")
                .content("내용1")
                .build();

        return new ResponseEntity<>(postEntity, HttpStatus.OK);
    }

    @GetMapping("/post")
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
