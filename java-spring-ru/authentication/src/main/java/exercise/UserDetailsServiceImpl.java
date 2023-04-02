package exercise;

import exercise.model.User;
import exercise.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Список полномочий, которые будут предоставлены пользователю после аутентификации
        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("user"));

        // BEGIN
        User user = repository.findByUsername(username).get();
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getPassword(), authorities);
        // END


    }
}

/*Далее мы должны указать, где найти информацию, необходимую для аутентификации.
Интерфейс UserDetailsService содержит единственный метод loadUserByUsername(),
который получает пользователя по его username. Этот метод мы должны переопределить.

Допишите метод loadUserByUsername(). Метод должен находить в репозитории пользователя по его имени.
Если пользователь не существует, должно быть выброшено исключение UserNotFoundException.

Метод должен вернуть запись пользователя – объект класса org.springframework.security.core.userdetails.User,
который реализует интерфейс UserDetails.
*/