package uz.pdp.app_card_transfer.repository;

import uz.pdp.app_card_transfer.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
/*
Akmal

 */

public interface CardRepository extends JpaRepository<Card, Long> {
    Card findByCardNumber(String cardNumber);
}
