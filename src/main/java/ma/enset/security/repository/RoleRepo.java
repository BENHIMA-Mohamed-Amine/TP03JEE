package ma.enset.security.repository;

import ma.enset.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, String> {
    Role findByRole(String role);
}
