package schedule.schedule.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import schedule.schedule.dto.LoginRequestDto;
import schedule.schedule.dto.UserResponseDto;
import schedule.schedule.entity.User;
import schedule.schedule.service.LoginService;
import schedule.schedule.service.UserService;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public String login(@Valid @RequestBody LoginRequestDto requestDto, HttpServletRequest httpRequest){

        loginService.login(requestDto, httpRequest);

        return "로그인 성공 ^0^";
    }


}
