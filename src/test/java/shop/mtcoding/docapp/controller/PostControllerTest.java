package shop.mtcoding.docapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import shop.mtcoding.docapp.MyWithRestDoc;
import shop.mtcoding.docapp.model.post.Post;

@AutoConfigureRestDocs(uriScheme = "http", uriHost = "localhost", uriPort = 8080)
@SpringBootTest
public class PostControllerTest extends MyWithRestDoc {

    @Test
    public void save_테스트() throws Exception {
        // given
        String content = new ObjectMapper().writeValueAsString(
                Post.builder().title("제목1").content("내용1").build());

        // when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/posts")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON_UTF8));
        // then
        resultActions
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("제목1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("내용1"))
                .andDo(MockMvcResultHandlers.print())
                .andDo(document);
    }

    @Test
    public void find_한건_테스트() throws Exception {
        // given
        Integer id = 1;

        // when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/posts/" + id));
        // then
        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("제목1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("내용1"))
                .andDo(MockMvcResultHandlers.print())
                .andDo(document);
    }

    @Test
    public void find_전체_테스트() throws Exception {
        // given

        // when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/posts"));
        // then
        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("[0].title").value("제목1"))
                .andExpect(MockMvcResultMatchers.jsonPath("[0].content").value("내용1"))
                .andExpect(MockMvcResultMatchers.jsonPath("[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("[1].title").value("제목2"))
                .andExpect(MockMvcResultMatchers.jsonPath("[1].content").value("내용2"))
                .andDo(MockMvcResultHandlers.print())
                .andDo(document);
    }
}
