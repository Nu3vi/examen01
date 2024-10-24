package com.cubas.examen01.rest;


import com.cubas.examen01.converter.EventoConverter;
import com.cubas.examen01.dto.EventoDto;
import com.cubas.examen01.entity.Evento;
import com.cubas.examen01.service.EventoService;
import com.cubas.examen01.util.WrapperResponse;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/eventos")
public class EventoController {
    @Autowired
    private EventoService service;

    @Autowired
    private EventoConverter converter;

    @GetMapping
    public ResponseEntity<List<Evento>> findAll(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize
    ) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<EventoDto> clientes = converter.fromEntities(service.findAll());

        return new WrapperResponse(true, "success", clientes).createResponse(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EventoDto> create (@RequestBody EventoDto evento) {
        Evento entity = converter.fromDTO(evento);
        EventoDto dto = converter.fromEntity(service.save(entity));

        return new WrapperResponse(true, "success", dto).createResponse(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoDto> update (@PathVariable("id") int id, @RequestBody EventoDto cliente) {
        Evento entity = converter.fromDTO(cliente);
        EventoDto dto = converter.fromEntity(service.save(entity));

        return new WrapperResponse(true, "success", dto).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable("id") int id) {
        service.delete(id);
//        return ResponseEntity.ok(null);
        return new WrapperResponse(true, "success", null).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDto> findById (@PathVariable("id") int id) {
        EventoDto dto = converter.fromEntity(service.findById(id));

        return new WrapperResponse(true, "success", dto).createResponse(HttpStatus.OK);
    }
}
