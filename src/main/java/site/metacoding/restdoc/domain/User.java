package site.metacoding.restdoc.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;

    @Builder
    public User(Integer id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
