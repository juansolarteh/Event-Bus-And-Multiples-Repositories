package com.example.demo.eventBus.domain;

import com.example.demo.eventBus.domain.exceptions.MissingTypeArgumentException;

public interface EventBus {
    void registerListener(EventListener listener) throws MissingTypeArgumentException;
    void publishEvent(Event event);
}
