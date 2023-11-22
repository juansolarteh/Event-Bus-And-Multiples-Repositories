package com.example.demo.shared.domain.eventBus;

public interface EventPublisher {
    void publishEvent(Event event);
}
