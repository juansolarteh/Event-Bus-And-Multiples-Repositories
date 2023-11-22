package com.example.demo.shared.infraestructure.eventBus;

import com.example.demo.shared.domain.eventBus.Event;
import com.example.demo.shared.domain.eventBus.EventPublisher;
import com.example.demo.shared.domain.eventBus.EventSubscriber;
import com.example.demo.shared.domain.eventBus.EventSubscriberRegister;
import com.example.demo.shared.domain.eventBus.exceptions.MissingTypeArgumentException;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InternalEventBus implements EventSubscriberRegister, EventPublisher {
    private final Map<Class<Event>, List<EventSubscriber>> subscribers = new HashMap<>();
    @Override
    public void registerSubscriber(EventSubscriber subscriber) throws MissingTypeArgumentException {
        System.out.println("New listener " + subscriber.getClass().getName());

        Type eventListenerType = subscriber.getClass().getGenericSuperclass();
        Class<?> eventClass = getParametrizedArgumentType(eventListenerType);
        addListener(eventClass, subscriber);
    }
    private Class<?> getParametrizedArgumentType(Type type) throws MissingTypeArgumentException {
        if (!(type instanceof ParameterizedType parameterizedType)) throw new MissingTypeArgumentException();
        Type[] argumentTypes = parameterizedType.getActualTypeArguments();
        return (Class<?>) argumentTypes[0];
    }
    private void addListener(Class<?> eventClass, EventSubscriber newEventListener){
        List<EventSubscriber> eventListeners = subscribers.get(eventClass);
        if (eventListeners == null) {
            List<EventSubscriber> listeners = new ArrayList<>();
            listeners.add(newEventListener);
            this.subscribers.put((Class<Event>) eventClass, listeners);
        }else eventListeners.add(newEventListener);
    }
    @Override
    public void publishEvent(Event event) {
        System.out.println("New event " + event.getClass().getName());
        List<EventSubscriber> eventListeners = subscribers.get(event.getClass());
        if (eventListeners == null) return;
        for (EventSubscriber listener : eventListeners){
            listener.onEvent(event);
        }
    }
}
