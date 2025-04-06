package ma.enset.security.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.enset.security.entities.AppUser;
import ma.enset.security.entities.Role;
import ma.enset.security.repository.AppUserRepo;
import ma.enset.security.repository.RoleRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AppUserRepo appUserRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public AppUser addNewUser(String username, String password, String confirmPassword, String email) {
        AppUser appUser = appUserRepo.findByUsername(username);
        if (appUser != null) {
            throw new RuntimeException("User already exists");
        }
        if (!password.equals(confirmPassword)) {
            throw new RuntimeException("Passwords do not match");
        }
        AppUser user = AppUser.builder()
                .userId(UUID.randomUUID().toString())
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build();
        appUserRepo.save(user);
        return user;
    }

    @Override
    public Role addNewRole(String roleName) {
        Role role = roleRepo.findByRole(roleName);
        if (role != null) {
            throw new RuntimeException("Role already exists");
        }
        Role newRole = Role.builder()
                .role(roleName)
                .build();
        roleRepo.save(newRole);
        return newRole;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepo.findByUsername(username);
        if (appUser == null) {
            throw new RuntimeException("User not found");
        }
        Role role = roleRepo.findByRole(roleName);
        if (role == null) {
            throw new RuntimeException("Role not found");
        }
        appUser.getRoles().add(role);
        appUserRepo.save(appUser);
    }

    @Override
    public void removeRoleFromUser(String username, String roleName) {
        AppUser appUser = appUserRepo.findByUsername(username);
        if (appUser == null) {
            throw new RuntimeException("User not found");
        }
        Role role = roleRepo.findByRole(roleName);
        if (role == null) {
            throw new RuntimeException("Role not found");
        }
        appUser.getRoles().remove(role);
        appUserRepo.save(appUser);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepo.findByUsername(username);
    }
}
