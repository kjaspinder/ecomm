package com.jaspinder.ecommsample.view.adapter;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;

import com.jaspinder.ecommsample.model.ProductListEntity;

public class ProductListDataSourcrFactory extends DataSource.Factory
{

	private MutableLiveData<PageKeyedDataSource<Integer, ProductListEntity>> itemLiveDataSource = new MutableLiveData<>();

	private static String id;

	public ProductListDataSourcrFactory(String categoryId)
	{
		id = categoryId;
	}
	@Override
	public DataSource create()
	{
		ProductListDataSorce dataSorce = new ProductListDataSorce(id);
		itemLiveDataSource.postValue(dataSorce);
		return dataSorce;
	}

	public MutableLiveData<PageKeyedDataSource<Integer, ProductListEntity>> getItemLiveDataSource()
	{
		return itemLiveDataSource;
	}
}
