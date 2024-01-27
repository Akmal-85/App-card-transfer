package uz.pdp.app_card_transfer.service;

import uz.pdp.app_card_transfer.entity.Card;
import uz.pdp.app_card_transfer.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
/*
Akmal

 */

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public Card findByCardNumber(String cardNumber) {
        return cardRepository.findByCardNumber(cardNumber);
    }

    public boolean transferMoney(String fromCardNumber, String toCardNumber, double amount) {
        Card fromCard = findByCardNumber(fromCardNumber);
        Card toCard = findByCardNumber(toCardNumber);

        if (fromCard != null && toCard != null && fromCard.getBalance() >= amount) {
            fromCard.setBalance(fromCard.getBalance() - amount);
            toCard.setBalance(toCard.getBalance() + amount);
            cardRepository.save(fromCard);
            cardRepository.save(toCard);
            return true;
        }

        return false;
    }
}
