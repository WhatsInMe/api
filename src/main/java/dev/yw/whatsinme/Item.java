package dev.yw.whatsinme;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;
    private int price;
    private int rating;
    private int lifetime;

    @JsonIgnore
    @OneToMany(
        mappedBy = "item",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL
    )
    private List<Unit> units;

    @Override
    public String toString() {
        return "Item [id=" + id + ", lifetime=" + lifetime + ", name=" + name + ", price=" + price + ", rating="
                + rating + "]";
    }

    public Item(String name, int price, int lifetime, int rating) {
        super();
        this.name = name;
        this.price = price;
        this.lifetime = lifetime;
        this.rating = rating;
    }

    public Item() {
        this("Unnamed Item", 0, 0, 0);
    }

    public Item(String name) {
        this(name, 0, 0, 0);
    }

    public Item(String name, int price) {
        this(name, price, 0, 0);
    }

    public Item(String name, int price, int lifetime) {
        this(name, price, lifetime, 0);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }
    
}
