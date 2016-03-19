package es.org.rxbusexample;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Clase que actuará como BUS de comunicación de Eventos.
 * @autor Óscar Rodríguez <oscar.garrucho@gmail.com>
 * @since 19/3/16 12:25
 */
public class RxBus {

    private static RxBus _rxbus;
    private final Subject<Object, Object> _bus = new SerializedSubject<>(PublishSubject.create());

    public RxBus(){

    }

    public static RxBus getInstance(){
        if (_rxbus == null){
            _rxbus = new RxBus();
        }
        return _rxbus;
    }

    public void send(Object o) {
        _bus.onNext(o);
    }

    public Observable<Object> toObserverable() {
        return _bus;
    }
}
