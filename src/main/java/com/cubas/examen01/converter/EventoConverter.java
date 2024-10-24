package com.cubas.examen01.converter;

import com.cubas.examen01.dto.EventoDto;
import com.cubas.examen01.entity.Evento;
import jdk.jfr.Event;
import org.springframework.stereotype.Component;

@Component
public class EventoConverter extends AbstractConverter<Evento, EventoDto>{
    @Override
    public EventoDto fromEntity(Evento entity) {
        if (entity == null) return null;

        return EventoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .Descripcion(entity.getDescripcion())
                .fechaInicio(entity.getFechaInicio())
                .fechaFin(entity.getFechaFin())
                .costo(entity.getCosto())
                .build();
    }

    @Override
    public Evento fromDTO(EventoDto dto) {
        if (dto == null) return null;

        return Evento.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .fechaInicio(dto.getFechaInicio())
                .fechaFin(dto.getFechaFin())
                .costo(dto.getCosto())
                .build();
    }
}
