package com.jaspinder.ecommsample.view.adapter;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import com.jaspinder.ecommsample.helper.AppConstants;
import com.jaspinder.ecommsample.model.Categories;
import com.jaspinder.ecommsample.model.ProductCategoriesData;
import com.jaspinder.ecommsample.network.FetchNetworkData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryDataSource extends PageKeyedDataSource<Integer, Categories>
{
	private static final String TAG = "CategoryDataSource";

	public static final int PAGE_SIZE = 15;

	public static final int FIRST_PAGE = 1;


	@Override
	public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Categories> callback)
	{
		FetchNetworkData.getRetrofitClient().getCategoriesData("json", PAGE_SIZE, FIRST_PAGE, AppConstants.api_key).enqueue(new Callback<ProductCategoriesData>()
		{
			@Override
			public void onResponse(Call<ProductCategoriesData> call, Response<ProductCategoriesData> response)
			{
				if (response.body() != null)
				{
					callback.onResult(response.body().getCategories(), null, FIRST_PAGE + 1);
				}
			}
			@Override
			public void onFailure(Call<ProductCategoriesData> call, Throwable t)
			{


			}
		});
	}
	@Override
	public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Categories> callback)
	{
		FetchNetworkData.getRetrofitClient().getCategoriesData("json", PAGE_SIZE, params.key, AppConstants.api_key).enqueue(new Callback<ProductCategoriesData>()
		{
			@Override
			public void onResponse(Call<ProductCategoriesData> call, Response<ProductCategoriesData> response)
			{
				Integer key = (params.key > 1) ? params.key - 1 : null;

				if (response.body() != null)
				{
					callback.onResult(response.body().getCategories(), key);
				}
			}
			@Override
			public void onFailure(Call<ProductCategoriesData> call, Throwable t)
			{

			}
		});
	}
	@Override
	public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Categories> callback)
	{
		FetchNetworkData.getRetrofitClient().getCategoriesData("json", PAGE_SIZE, params.key, AppConstants.api_key).enqueue(new Callback<ProductCategoriesData>()
		{
			@Override
			public void onResponse(Call<ProductCategoriesData> call, Response<ProductCategoriesData> response)
			{


				if (response.body() != null)
				{
					Integer key = (params.key < response.body().getTotalPages()) ? params.key + 1 : null;
					callback.onResult(response.body().getCategories(), key);
				}
			}
			@Override
			public void onFailure(Call<ProductCategoriesData> call, Throwable t)
			{

			}
		});
	}
}
