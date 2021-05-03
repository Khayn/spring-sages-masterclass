package spring.masterclass.sages.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.masterclass.sages.common.UriBuilder;

import java.net.URI;

@RequestMapping("/api/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private UriBuilder uriBuilder = new UriBuilder();

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        Long userId = userService
                .add(user)
                .getId();

        URI locationUri = uriBuilder.requestUriWithId(userId);

        return ResponseEntity
                .created(locationUri)
                .build();

    }

    @GetMapping("{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        User user = userService.findById(userId);

        return ResponseEntity.ok(user);
    }

}
