package org.benoitdubreuil.iree.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that exists to conveniently implement the {@link IObservable} interface without having to implement its method and add a new variable.
 *
 * @param <M> The model type.
 */
public class Observable<M> implements IObservable<M> {

    private List<IObserver<M>> m_observers;

    public Observable() {
        m_observers = new ArrayList<>();
    }

    @Override
    public void modelChanged(M newValue) {
        for (IObserver<M> observer : m_observers)
            observer.observableChanged(newValue);
    }

    @Override
    public void addObserver(IObserver<M> observer) {
        m_observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver<M> observer) {
        m_observers.remove(observer);
    }

    @Override
    public void clearObservers() {
        m_observers.clear();
    }
}
