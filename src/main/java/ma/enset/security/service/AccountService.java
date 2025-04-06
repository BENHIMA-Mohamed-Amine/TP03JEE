package ma.enset.security.service;

import ma.enset.security.entities.AppUser;
import ma.enset.security.entities.Role;

public interface AccountService {
    AppUser addNewUser(String username, String password, String confirmPassword, String email);
    Role addNewRole(String roleName);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    AppUser loadUserByUsername(String username);
}
