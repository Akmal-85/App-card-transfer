package uz.pdp.app_card_transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.app_card_transfer.entity.Users;
/*
Akmal

 */

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
