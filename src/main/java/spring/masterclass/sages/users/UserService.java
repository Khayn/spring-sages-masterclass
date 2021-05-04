package spring.masterclass.sages.users;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import spring.masterclass.sages.common.PagedResult;

import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User add(User user) {
        return userRepository.save(user);
    }

    public User findById(Long userId) {
        return userRepository
                .findById(userId)
                .orElseThrow(UserNotFoundException::new);
    }

    public PagedResult<User> getByLastName(String lastNameFragment, int pageNumber, int pageSize) {
        var userPage = userRepository.findByLastNameContaining(lastNameFragment, PageRequest.of(pageNumber, pageSize));

        return new PagedResult<>(userPage.getContent(), pageNumber, userPage.getTotalPages());
    }

    public PagedResult<User> getAll(int pageNumber, int pageSize) {
        var userPage = userRepository.findAll(PageRequest.of(pageNumber, pageSize));

        return new PagedResult<>(userPage.getContent(), pageNumber, userPage.getTotalPages());
    }

}
