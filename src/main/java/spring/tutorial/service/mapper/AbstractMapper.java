package spring.tutorial.service.mapper;

import com.google.common.collect.Lists;
import spring.tutorial.dto.Identifiable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Robert on 10/11/2015.
 */
public abstract class AbstractMapper<DTO extends Identifiable, ENTITY extends Identifiable> {
    public abstract DTO map(ENTITY entity);

    public List<DTO> map(Collection<ENTITY> entities) {
        List<DTO> dtos;
        if (entities != null) {
            dtos = new ArrayList<>(entities.size());
            dtos.addAll(entities.stream().map(this::map).collect(Collectors.toList()));
        } else {
            dtos = Lists.newArrayList();
        }
        return dtos;
    }

    public abstract void map(DTO dto, ENTITY entity);
}
