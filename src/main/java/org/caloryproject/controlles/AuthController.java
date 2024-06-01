package org.caloryproject.controlles;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.caloryproject.dto.LoginDto;
import org.caloryproject.dto.UserDto;
import org.caloryproject.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(LoginDto loginDto, HttpServletResponse response) {
        return authService.login(loginDto, response);
    }

    @PostMapping("/register")
    public void register(UserDto userDto) {
        authService.register(userDto);
    }

    @GetMapping("/send-code")
    public void sendCode(HttpServletRequest request) {
        authService.sendCode(request);
    }

    @PutMapping("/{code}")
    public void writeCode(HttpServletRequest request,@PathVariable Integer code) {
        authService.writeCode(request, code);
    }
}
