package com.jaspinder.ecommsample.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;
import android.util.Log;

import com.jaspinder.ecommsample.events.IFetchCategoryFailEvent;
import com.jaspinder.ecommsample.events.IFetchCategorySuccessEvent;
import com.jaspinder.ecommsample.helper.IBusinessExecutor;
import com.jaspinder.ecommsample.helper.IEventBus;
import com.jaspinder.ecommsample.model.Categories;
import com.jaspinder.ecommsample.model.NetworkResponseData;
import com.jaspinder.ecommsample.model.ProductListEntity;
import com.jaspinder.ecommsample.network.FetchNetworkData;
import com.jaspinder.ecommsample.network.IFetchNetworkData;
import com.jaspinder.ecommsample.view.adapter.CategoryDataSource;
import com.jaspinder.ecommsample.view.adapter.CategoryDataSourceFactory;
import com.jaspinder.ecommsample.view.adapter.ProductListAdaptor;
import com.jaspinder.ecommsample.view.adapter.ProductListDataSorce;
import com.jaspinder.ecommsample.view.adapter.ProductListDataSourcrFactory;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class ProductsFragViewModel extends BaseViewModel
{

	private static final String TAG = "ProductsFragViewModel";

	private MutableLiveData<NetworkResponseData> networkResponseDataMutableLiveData = new MutableLiveData<>();

	private MutableLiveData<List<Categories>> categoryList = new MutableLiveData<>();

	private LiveData<PagedList<Categories>> categoriesPageList ;


	private LiveData<PageKeyedDataSource<Integer,Categories>> liveDataSource;

	private LiveData<PagedList<ProductListEntity>> productPagedList ;


	private LiveData<PageKeyedDataSource<Integer,ProductListEntity>> productLiveDataSource;



	private static IFetchNetworkData fetchNetworkData = new FetchNetworkData();

	public ProductsFragViewModel(IEventBus eventbus, IBusinessExecutor businessExecutor)
	{
		super(eventbus, businessExecutor);
		CategoryDataSourceFactory categoryDataSourceFactory = new CategoryDataSourceFactory();
		liveDataSource = categoryDataSourceFactory.getItemLiveDataSource();

		PagedList.Config config = (new PagedList.Config.Builder())
				.setEnablePlaceholders(false)
				.setPageSize(CategoryDataSource.PAGE_SIZE)
				.build();

		categoriesPageList = (new LivePagedListBuilder(categoryDataSourceFactory,config)).build();
		fetchNetworkData.onStart();

	}


	public void getProductsForSelectedCategory(String categoryId)
	{
		ProductListDataSourcrFactory productListDataSourcrFactory = new ProductListDataSourcrFactory(categoryId);
		productLiveDataSource = productListDataSourcrFactory.getItemLiveDataSource();

		PagedList.Config config = (new PagedList.Config.Builder())
				.setEnablePlaceholders(false)
				.setPageSize(ProductListDataSorce.PAGE_SIZE)
				.build();

		productPagedList = (new LivePagedListBuilder(productListDataSourcrFactory,config)).build();
	}

	public LiveData<PagedList<Categories>> getCategoriesPageList()
	{
		return categoriesPageList;
	}

	public LiveData<PagedList<ProductListEntity>> getProductPagedList()
	{
		return productPagedList;
	}
	public void setCategoriesPageList(LiveData<PagedList<Categories>> categoriesPageList)
	{
		this.categoriesPageList = categoriesPageList;
	}
	public LiveData<PageKeyedDataSource<Integer, Categories>> getLiveDataSource()
	{
		return liveDataSource;
	}
	public void setLiveDataSource(LiveData<PageKeyedDataSource<Integer, Categories>> liveDataSource)
	{
		this.liveDataSource = liveDataSource;
	}
	public void getCategoryData()
	{
		Log.d(TAG, "getCategoryData");

		if (categoryList.getValue() == null)
		{
			businessExecutor.executeInBusinessThread(new Runnable()
			{
				@Override
				public void run()
				{
					fetchNetworkData.fetchCategoryList();
				}
			});
		}
	}

	public MutableLiveData<NetworkResponseData> getNetworkResponseDataMutableLiveData()
	{
		return networkResponseDataMutableLiveData;
	}
	public MutableLiveData<List<Categories>> getCategoryList()
	{
		return categoryList;
	}
	@Subscribe
	public void onCategoriesDataFetchFail(IFetchCategoryFailEvent fail)
	{
		networkResponseDataMutableLiveData.postValue(fail.getNetworkResponseData());
	}

	@Subscribe
	public void onCategoryDataSuccessEvent(IFetchCategorySuccessEvent success)
	{
		categoryList.postValue(success.getProductCategoryData().getCategories());
	}


}

