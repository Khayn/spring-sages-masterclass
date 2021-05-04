package spring.masterclass.sages.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.masterclass.sages.common.web.PagedResultTransferObject;
import spring.masterclass.sages.common.web.UriBuilder;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequestMapping("/api/users")
@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final UriBuilder uriBuilder = new UriBuilder();

    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody UserTransferObject userTransferObject,
                                        BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity
                    .badRequest()
                    .build();
        }

        User user = userMapper.toUser(userTransferObject);
        Long userId = userService
                .add(user)
                .getId();

        URI locationUri = uriBuilder.requestUriWithId(userId);

        return ResponseEntity
                .created(locationUri)
                .build();

    }

    @GetMapping("{userId}")
    public ResponseEntity<UserTransferObject> getUser(@PathVariable Long userId) {
        User user = userService.findById(userId);
        UserTransferObject userTransferObject = userMapper.toUserTransferObject(user);
        userTransferObject.add(linkTo(methodOn(UserRestController.class)
                .getUser(userId))
                .withSelfRel());

        return ResponseEntity.ok(userTransferObject);
    }

    @GetMapping
    public PagedResultTransferObject<UserTransferObject> getUsersByLastName(
            @RequestParam String lastNameFragment,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize) {
        var users = userService.getByLastName(lastNameFragment, pageNumber, pageSize);

        return userMapper.toUserTransferObjectPage(users);
    }

    @GetMapping("/all")
    public PagedResultTransferObject<UserTransferObject> getAllUsers(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize) {
        var users = userService.getAll(pageNumber, pageSize);

        return userMapper.toUserTransferObjectPage(users);
    }

}
