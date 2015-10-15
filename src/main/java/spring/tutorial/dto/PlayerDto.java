package spring.tutorial.dto;

import java.time.LocalDateTime;

/**
 * Created by Robert on 10/15/2015.
 */
public class PlayerDto implements Identifiable{
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
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
