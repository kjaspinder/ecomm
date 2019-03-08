package com.jaspinder.ecommsample.view.adapter;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import com.jaspinder.ecommsample.helper.AppConstants;
import com.jaspinder.ecommsample.model.ProductCategoriesData;
import com.jaspinder.ecommsample.model.ProductListData;
import com.jaspinder.ecommsample.model.ProductListEntity;
import com.jaspinder.ecommsample.network.FetchNetworkData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProductListDataSorce extends PageKeyedDataSource<Integer, ProductListEntity>
{

	public static final int PAGE_SIZE = 10;

	public static final int FIRST_PAGE = 1;

	private static String categoryId;


	public ProductListDataSorce(String category){
		categoryId = category;
	}


	@Override
	public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, ProductListEntity> callback)
	{
		FetchNetworkData.getRetrofitClient().getProductListData(categoryId, PAGE_SIZE, FIRST_PAGE, AppConstants.api_key).enqueue(new Callback<ProductListData>()
		{
			@Override
			public void onResponse(Call<ProductListData> call, Response<ProductListData> response)
			{
				if (response.body() != null)
				{
					callback.onResult(response.body().getResults(), null, FIRST_PAGE + 1);
				}
			}
			@Override
			public void onFailure(Call<ProductListData> call, Throwable t)
			{


			}
		});
	}
	@Override
	public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, ProductListEntity> callback)
	{
		FetchNetworkData.getRetrofitClient().getProductListData(categoryId, PAGE_SIZE, params.key, AppConstants.api_key).enqueue(new Callback<ProductListData>()
		{
			@Override
			public void onResponse(Call<ProductListData> call, Response<ProductListData> response)
			{
				Integer key = (params.key > 1) ? params.key - 1 : null;

				if (response.body() != null)
				{
					callback.onResult(response.body().getResults(), key);
				}
			}
			@Override
			public void onFailure(Call<ProductListData> call, Throwable t)
			{

			}
		});
	}
	@Override
	public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, ProductListEntity> callback)
	{
		FetchNetworkData.getRetrofitClient().getProductListData(categoryId, PAGE_SIZE, params.key, AppConstants.api_key).enqueue(new Callback<ProductListData>()
		{
			@Override
			public void onResponse(Call<ProductListData> call, Response<ProductListData> response)
			{


				if (response.body() != null)
				{
					Integer key = (params.key < response.body().getPage().getTotal()) ? params.key + 1 : null;
					callback.onResult(response.body().getResults(), key);
				}
			}
			@Override
			public void onFailure(Call<ProductListData> call, Throwable t)
			{

			}
		});
	}
}
