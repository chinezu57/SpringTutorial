package spring.tutorial.domain;

import spring.tutorial.dto.Identifiable;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Robert on 10/15/2015.
 */
@Entity
public class Player implements Identifiable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String weapon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
