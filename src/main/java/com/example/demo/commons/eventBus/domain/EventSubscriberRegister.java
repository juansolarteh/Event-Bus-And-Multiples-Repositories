package com.example.demo.commons.eventBus.domain;

import com.example.demo.commons.eventBus.domain.exceptions.MissingTypeArgumentException;

public interface EventSubscriberRegister {
    void registerSubscriber(EventSubscriber eventSubscriber) throws MissingTypeArgumentException;
}
