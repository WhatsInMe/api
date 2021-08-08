package dev.yw.whatsinme;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/test")
    public ResponseEntity test(){
        return new ResponseEntity<>("sup", HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Item>> items(){
        return new ResponseEntity<>(
            itemRepository.findAll(),
            HttpStatus.OK
        );
    }

    @PostMapping("")
    public ResponseEntity<Item> create(@RequestBody Item item){
        return new ResponseEntity<>(
            itemRepository.save(item), 
            HttpStatus.CREATED
        );
    }

    @GetMapping("/{name}")
    public ResponseEntity<Item> item(
        @PathVariable("name") String name
    ){
        return new ResponseEntity<>(
            itemRepository.findByName(name),
            HttpStatus.OK
        );
    }
    
}
