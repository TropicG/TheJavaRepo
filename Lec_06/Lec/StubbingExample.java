import java.util.HashMap;
import java.util.Map;

record User(String email, String password) {

}

interface UserRepository {
    boolean exists (String email);
    void save(User user);
}

class UserService {

    private UserRepository repository;

    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }

    public User register(String email, String password) {
        if (repository.exists(email)) {
            throw new UserAlreadyExistsException();
        }

        User user = new User(email, password);
        repository.save(user);
        return user;
    }
}

//actual stubs that upon calling exits method we have automaticly true
class PositiveUserRepositoryStubImpl implements UserRepository {

    @Override
    public boolean exists(String email) {
        return true;
    }

    @Override
    public void save(User user) {
        // do nothing
    }
}

class InMemoryUserRepositoryStubImpl implements UserRepository {
    private Map<String, User> users = new HashMap<>();

    @Override
    public boolean exists(String email){
        return users.containsKey(email);
    }

    @Override
    public void save(User user) {
        users.put(user.email(), user);
    }
}

class StubbingExample {

    @Test
    void testRegisterThrowsAppropriateException() {

        UserRepository repository = new PositiveUserRepositoryStubImpl();
        UserService service = new UserService(repository);

        assertThrows(UserAlreadyExistsException.class, () -> service.register("test@test.com", "weak"),
                "Expected UserAlreadyExistsException but it was not thrown");

    }
}
