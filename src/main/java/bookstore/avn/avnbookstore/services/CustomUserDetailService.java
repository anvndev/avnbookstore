package bookstore.avn.avnbookstore.services;


import bookstore.avn.avnbookstore.entity.CustomUserDetail;
import bookstore.avn.avnbookstore.entity.User;
import bookstore.avn.avnbookstore.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("User not found");
        return new  CustomUserDetail(user, userRepository);
    }
}
