package ru.itis.hateoas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.*;
import ru.itis.hateoas.services.ReserveServiceProducer;

@RepositoryRestController
public class CustomReserveController {

    private final ReserveServiceProducer reserveServiceProducer;

    @Autowired
    public CustomReserveController(ReserveServiceProducer reserveServiceProducer) {
        this.reserveServiceProducer = reserveServiceProducer;
    }

    @PutMapping("/places/{place-id}/desks/{desk-id}/reserve")
    public @ResponseBody
    CharSequence reserve(@PathVariable("place-id") final Long placeId,
                              @PathVariable("desk-id") final Long deskId) {
        reserveServiceProducer.reserve(placeId, deskId);
        return "Message published";
    }
}
