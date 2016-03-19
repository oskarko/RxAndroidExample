package es.org.rxbusexample;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment {

    private RxBus _rxBus;
    private CompositeSubscription _subscriptions;

    public FragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);;

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        _subscriptions = new CompositeSubscription();
        _rxBus = RxBus.getInstance();

        _subscriptions
                .add(_rxBus.toObserverable()
                        .subscribe(new Action1<Object>() {
                            @Override
                            public void call(Object event) {
                                if (event instanceof OskarkoEvent) {
                                    Snackbar.make(getView(), ((OskarkoEvent) event).getText(), Snackbar.LENGTH_SHORT).show();
                                }
                            }
                        }));
    }

    @Override
    public void onStop() {
        super.onStop();
        _subscriptions.unsubscribe();
    }
}
