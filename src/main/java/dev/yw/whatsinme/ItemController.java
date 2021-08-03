package dev.yw.whatsinme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/test")
    public ResponseEntity test(){
        return new ResponseEntity<>("sup", HttpStatus.OK);
    }
    
}
