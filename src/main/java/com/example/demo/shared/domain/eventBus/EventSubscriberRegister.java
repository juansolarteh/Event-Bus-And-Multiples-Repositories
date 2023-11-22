package com.example.demo.shared.domain.eventBus;

import com.example.demo.shared.domain.eventBus.exceptions.MissingTypeArgumentException;

public interface EventSubscriberRegister {
    void registerSubscriber(EventSubscriber eventSubscriber) throws MissingTypeArgumentException;
}
