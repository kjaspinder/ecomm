package com.jaspinder.ecommsample.view.adapter;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;

import com.jaspinder.ecommsample.model.Categories;


public class CategoryDataSourceFactory extends DataSource.Factory
{

	private MutableLiveData<PageKeyedDataSource<Integer, Categories>> itemLiveDataSource = new MutableLiveData<>();
	@Override
	public DataSource create()
	{
		CategoryDataSource categoryDataSource = new CategoryDataSource();
		itemLiveDataSource.postValue(categoryDataSource);
		return categoryDataSource;
	}

	public MutableLiveData<PageKeyedDataSource<Integer, Categories>> getItemLiveDataSource()
	{
		return itemLiveDataSource;
	}
}
