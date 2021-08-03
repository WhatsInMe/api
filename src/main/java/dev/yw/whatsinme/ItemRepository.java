package dev.yw.whatsinme;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    
}

// public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
//     List<Bookmark> findByDescription(String description);
//     Bookmark findById(long id);
// }