package site.metacoding.restdoc.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Post {
    private Integer id;
    private String title;
    private String content;

    @Builder
    public Post(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
