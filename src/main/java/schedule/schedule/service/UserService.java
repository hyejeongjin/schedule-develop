package schedule.schedule.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import schedule.schedule.dto.SignUpResponseDto;
import schedule.schedule.dto.UserResponseDto;
import schedule.schedule.entity.User;
import schedule.schedule.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public SignUpResponseDto signUp(String username, String password, String email) {

        User user = new User(username, password, email);

        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getUser_id(), savedUser.getUsername(), savedUser.getEmail());

    }

    public UserResponseDto findById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id : " + id);
        }

        User findUser = optionalUser.get();

        return new UserResponseDto(findUser.getUsername(), findUser.getEmail());
    }

    @Transactional
    public UserResponseDto updateUser(Long id, String username, String password, String email) {

        //묻지말고 시켜라?
        checkPassword(id, password);

        return new UserResponseDto(username, email);

    }

    public void delete(Long id) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        userRepository.delete(findUser);
    }

    public void checkPassword(Long id, String password){
        User user = userRepository.findByIdOrElseThrow(id);
        if(!user.getPassword().equals(password)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong password!!");
        }
    }
}
