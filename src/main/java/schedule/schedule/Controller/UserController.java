package schedule.schedule.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schedule.schedule.dto.SignUpRequestDto;
import schedule.schedule.dto.SignUpResponseDto;
import schedule.schedule.dto.UserResponseDto;
import schedule.schedule.dto.UserUpdateRequestDto;
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
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id,
                                                      @RequestBody UserUpdateRequestDto requestDto){

        return new ResponseEntity<>(userService.updateUser(id, requestDto.getUsername(), requestDto.getPassword(), requestDto.getEmail()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }



}
