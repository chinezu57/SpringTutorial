package spring.tutorial.service.mapper;

import spring.tutorial.domain.Player;
import spring.tutorial.dto.PlayerDto;

/**
 * Created by Robert on 10/15/2015.
 */
public class PlayerMapper extends AbstractMapper<PlayerDto, Player> {
    @Override
    public PlayerDto map(Player player) {
        PlayerDto playerDto = new PlayerDto();
        playerDto.setName(player.getName());
        playerDto.setWeapon(player.getWeapon());
        return playerDto;
    }

    @Override
    public void map(PlayerDto playerDto, Player player) {
        player.setWeapon(playerDto.getWeapon());
        player.setName(playerDto.getName());
    }
}
