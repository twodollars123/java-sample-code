package vn.threecents.java_sample_code.controller;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.threecents.java_sample_code.dto.request.UserRequestDTO;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @PostMapping("/")
    public String addUser(@Valid @RequestBody UserRequestDTO user) {
        return "add an user successfully";
    }
    @PutMapping("/{userId}")
    public String updateUser(@PathVariable int userId,@Valid @RequestBody UserRequestDTO user) {
        return "updated user successfully";
    }
    @PatchMapping("/{userId}")
    public String changeUserStatus(@PathVariable int userId,@Valid @RequestParam(defaultValue = "0", required = true) boolean status) {
        return "changed user's status successfully";
    }
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId) {
        return "deleted user successfully";
    }
    @GetMapping("/{userId}")
    public UserRequestDTO getUser(@PathVariable int userId) {
        return new UserRequestDTO("tuan", "nguyen", "tuannguyen@gmail.com", "0933462839");
    }
}
