package com.example.demo.eventBus.domain;

import com.example.demo.eventBus.domain.exceptions.MissingTypeArgumentException;

public abstract class EventListener<T extends Event> {
    public EventListener(EventBus eventBus) throws MissingTypeArgumentException {
        eventBus.registerListener(this);
    }
    public abstract void onEvent(T event);
}
