package com.jaspinder.ecommsample.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.jaspinder.ecommsample.helper.BusinessExecutor;
import com.jaspinder.ecommsample.helper.EventBusImpl;
import com.jaspinder.ecommsample.helper.IBusinessExecutor;
import com.jaspinder.ecommsample.helper.IEventBus;
public class ViewModelProviderFactory implements ViewModelProvider.Factory
{

	private static ViewModelProviderFactory viewModelProvider = new ViewModelProviderFactory();

	private IEventBus eventBus;

	private IBusinessExecutor businessExecutor;

	private ViewModelProviderFactory()
	{
		this.eventBus = EventBusImpl.getInstance();
		this.businessExecutor = BusinessExecutor.getInstance();
	}

	public static ViewModelProviderFactory getInstance(){return viewModelProvider;}
	@NonNull
	@Override
	public <T extends ViewModel> T create(@NonNull Class<T> modelClass)
	{

		if (modelClass.isAssignableFrom(ProductsFragViewModel.class)) {
			return (T) new ProductsFragViewModel(eventBus, businessExecutor);
		}
		throw new IllegalArgumentException("Unknown model class " + modelClass);
	}
}
