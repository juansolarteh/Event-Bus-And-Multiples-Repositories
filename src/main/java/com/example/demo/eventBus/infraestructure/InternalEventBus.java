package com.example.demo.eventBus.infraestructure;

import com.example.demo.eventBus.domain.Event;
import com.example.demo.eventBus.domain.EventBus;
import com.example.demo.eventBus.domain.EventListener;
import com.example.demo.eventBus.domain.exceptions.MissingTypeArgumentException;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InternalEventBus implements EventBus {
    private final Map<Class<Event>, List<EventListener>> listeners = new HashMap<>();
    @Override
    public void registerListener(EventListener listener) throws MissingTypeArgumentException {
        System.out.println("New listener " + listener.getClass().getName());

        Type eventListenerType = listener.getClass().getGenericSuperclass();
        Class<?> eventClass = getParametrizedArgumentType(eventListenerType);
        addListener(eventClass, listener);
    }
    private Class<?> getParametrizedArgumentType(Type type) throws MissingTypeArgumentException {
        if (!(type instanceof ParameterizedType parameterizedType)) throw new MissingTypeArgumentException();
        Type[] argumentTypes = parameterizedType.getActualTypeArguments();
        return (Class<?>) argumentTypes[0];
    }
    private void addListener(Class<?> eventClass, EventListener newEventListener){
        List<EventListener> eventListeners = listeners.get(eventClass);
        if (eventListeners == null) {
            List<EventListener> listeners = new ArrayList<>();
            listeners.add(newEventListener);
            this.listeners.put((Class<Event>) eventClass, listeners);
        }else eventListeners.add(newEventListener);
    }
    @Override
    public void publishEvent(Event event) {
        System.out.println("New event " + event.getClass().getName());
        List<EventListener> eventListeners = listeners.get(event.getClass());
        if (eventListeners == null) return;
        for (EventListener listener : eventListeners){
            listener.onEvent(event);
        }
    }
}
