package vn.threecents.java_sample_code.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.threecents.java_sample_code.dto.request.UserRequestDTO;
import vn.threecents.java_sample_code.dto.response.ResponseFailure;
import vn.threecents.java_sample_code.dto.response.ResponseSuccess;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @PostMapping("/")
    public ResponseSuccess addUser(@Valid @RequestBody UserRequestDTO user) {
        System.out.println("add user");
        try {
            return new ResponseSuccess(HttpStatus.CREATED, "User added successfully");
        } catch (Exception ex) {
            return new ResponseFailure(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
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
