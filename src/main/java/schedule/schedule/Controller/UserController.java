package schedule.schedule.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schedule.schedule.dto.*;
import schedule.schedule.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto){
        SignUpResponseDto signUpResponseDto = userService.signUp(requestDto.getUsername(), requestDto.getPassword(), requestDto.getEmail());

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    /**
     *
     * @param id
     * id별 유저를 조회한다.
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id){
        UserResponseDto userResponseDto = userService.findById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserUpdateResponseDto> updateUser(@PathVariable Long id,
                                                      @RequestBody UserUpdateRequestDto requestDto){

        UserUpdateResponseDto userUpdateResponseDto = userService.updateUser(id, requestDto);

        return new ResponseEntity<>(userUpdateResponseDto, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(HttpServletRequest httpRequest){

        HttpSession session = httpRequest.getSession();

        Long loginUser = (Long) session.getAttribute("loginUser");

        userService.delete(loginUser);

        // 세션 초기화
        session.invalidate();

        return new ResponseEntity<>(HttpStatus.OK);
    }



}
