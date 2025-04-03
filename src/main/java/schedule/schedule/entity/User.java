package schedule.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Getter
@Entity
@Table(name = "user")
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // 이메일 체크, 비밀번호 체크
    public void isEmail(String email){
        if(!this.getEmail().equals(email)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong email!!");
        }
    }

    public void isPassword(String password){
        if(!this.getPassword().equals(password)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong password!!");
        }
    }

}
