package com.jaspinder.ecommsample.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModel;

import com.jaspinder.ecommsample.helper.IBusinessExecutor;
import com.jaspinder.ecommsample.helper.IEventBus;
public class BaseViewModel extends ViewModel implements LifecycleObserver
{

	protected IEventBus eventBus;
	protected IBusinessExecutor businessExecutor;

	public BaseViewModel(IEventBus eventbus, IBusinessExecutor businessExecutor) {
		super();
		this.eventBus = eventbus;
		this.businessExecutor = businessExecutor;
	}

	@OnLifecycleEvent(Lifecycle.Event.ON_START)
	public void onStart() {
		eventBus.register(this);
	}

	@OnLifecycleEvent(Lifecycle.Event.ON_STOP)
	public void onStop() {
		eventBus.unregister(this);
	}


}
