package ma.enset.security.repository;

import ma.enset.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
}
