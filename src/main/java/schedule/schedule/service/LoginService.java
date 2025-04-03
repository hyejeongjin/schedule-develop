package schedule.schedule.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import schedule.schedule.dto.LoginRequestDto;
import schedule.schedule.entity.User;
import schedule.schedule.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    //로그인
    public User login(LoginRequestDto loginRequestDto, HttpServletRequest httpRequest){

        User findUser =  userRepository.findByEmailOrElseThrow(loginRequestDto.getEmail());

        findUser.isEmail(loginRequestDto.getEmail());
        findUser.isPassword(loginRequestDto.getPassword());

        HttpSession session = httpRequest.getSession(true);

        session.setAttribute("loginUser", findUser.getUser_id());

        return findUser;
    }

}
