package app.controller;

import app.model.dto.request.CreateUserAnswerRequest;
import app.model.dto.request.UpdateUserAnswerRequest;
import app.model.dto.response.UserAnswerDTO;
import app.service.common.UserAnswerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-answers")
public class UserAnswerController {

    private final UserAnswerService userAnswerService;

    @PostMapping
    public ResponseEntity<UserAnswerDTO> create(@RequestHeader("email") String email, @RequestBody @Valid CreateUserAnswerRequest request) {
        return ok(userAnswerService.create(email, request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAnswerDTO> update(@PathVariable("id") Long id, @RequestBody UpdateUserAnswerRequest updateRequest) {
        return ok(userAnswerService.update(id, updateRequest));
    }

}
