package com.example.demo.shared.domain.eventBus;

import com.example.demo.shared.domain.eventBus.exceptions.MissingTypeArgumentException;

public abstract class EventSubscriber<T extends Event> {
    public EventSubscriber(EventSubscriberRegister eventSubscriberRegister) throws MissingTypeArgumentException {
        eventSubscriberRegister.registerSubscriber(this);
    }
    public abstract void onEvent(T event);
}
