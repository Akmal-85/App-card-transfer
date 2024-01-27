package uz.pdp.app_card_transfer.service;

import uz.pdp.app_card_transfer.entity.Card;
import uz.pdp.app_card_transfer.entity.Users;
import uz.pdp.app_card_transfer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
/*
Akmal

 */

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public List<Card> getUserCards(String username) {
        Users user = userRepository.findByUsername(username);
        if (user != null) {
            return user.getCards();
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public Card getUserCard(String username, String cardName) {
        return userRepository.findByUsername(username).getCards().stream().filter(c -> c.getCardName().equals(cardName)).findFirst().orElse(null);
    }
}
