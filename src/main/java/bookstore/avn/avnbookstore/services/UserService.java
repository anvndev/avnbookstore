package bookstore.avn.avnbookstore.services;

import bookstore.avn.avnbookstore.entity.User;
import bookstore.avn.avnbookstore.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    public void save(User user){
        userRepository.save(user);
    }
}
