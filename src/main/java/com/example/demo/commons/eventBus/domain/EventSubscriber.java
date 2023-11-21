package com.example.demo.commons.eventBus.domain;

import com.example.demo.commons.eventBus.domain.exceptions.MissingTypeArgumentException;

public abstract class EventSubscriber<T extends Event> {
    public EventSubscriber(EventSubscriberRegister eventSubscriberRegister) throws MissingTypeArgumentException {
        eventSubscriberRegister.registerSubscriber(this);
    }
    public abstract void onEvent(T event);
}
