package uz.pdp.app_card_transfer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.app_card_transfer.entity.Card;
import uz.pdp.app_card_transfer.service.CardService;
import uz.pdp.app_card_transfer.service.UserService;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

public class userController {
    final UserService userService;
    private final CardService cardService;


    @GetMapping("/user/{username}/cards")
    public ResponseEntity<List<Card>> getUserCards(@PathVariable String username) {
        List<Card> cards = userService.getUserCards(username);
        if (cards != null) {
            return ResponseEntity.ok(cards);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/user/{username}/{cardName}")
    public ResponseEntity<Card> getUserCard(@PathVariable String username, @PathVariable String cardName) {
        Card card = userService.getUserCard(username, cardName);
        return ResponseEntity.ok(card);
    }


    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(@RequestParam String fromCardNumber, @RequestParam String toCardNumber, @RequestParam double amount) {
        if (cardService.transferMoney(fromCardNumber, toCardNumber, amount)) {
            return ResponseEntity.ok("Pul o'tkazildi");
        } else {
            return ResponseEntity.badRequest().body("Pul o'tkazish muvaffaqiyatsiz");
        }
    }
}
