package com.jaspinder.ecommsample.network;

import android.util.Log;

import com.jaspinder.ecommsample.AppController;
import com.jaspinder.ecommsample.R;
import com.jaspinder.ecommsample.events.IFetchCategoryFailEvent;
import com.jaspinder.ecommsample.events.IFetchCategorySuccessEvent;
import com.jaspinder.ecommsample.helper.AppConstants;
import com.jaspinder.ecommsample.helper.BusinessExecutor;
import com.jaspinder.ecommsample.helper.EventBusImpl;
import com.jaspinder.ecommsample.helper.IBusinessExecutor;
import com.jaspinder.ecommsample.helper.IEventBus;
import com.jaspinder.ecommsample.helper.RetrofitCalls;
import com.jaspinder.ecommsample.model.NetworkResponseData;
import com.jaspinder.ecommsample.model.ProductCategoriesData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class FetchNetworkData implements IFetchNetworkData
{
	private static final String TAG = "FetchNetworkData";

	private IBusinessExecutor mBusinessExecutor;

	private IEventBus mEventBus;

	private static Retrofit retrofit;

	private RetrofitCalls mRetrofitCalls;


	@Override
	public void onStart()
	{
		Log.d(TAG, "onstart");
		mBusinessExecutor = BusinessExecutor.getInstance();
		mEventBus = EventBusImpl.getInstance();


	}

	public static RetrofitCalls getRetrofitClient(){
		retrofit = new Retrofit.Builder().baseUrl(AppConstants.base_url).addConverterFactory(GsonConverterFactory.create()).build();
		return retrofit.create(RetrofitCalls.class);
	}

	@Override
	public void fetchCategoryList()
	{
		Call<ProductCategoriesData> call = getRetrofitClient().getCategoriesData("json",15,1, AppConstants.api_key);
		call.enqueue(new Callback<ProductCategoriesData>()
		{
			@Override
			public void onResponse(Call<ProductCategoriesData> call, final Response<ProductCategoriesData> response)
			{
				if (response.body() != null)
				{
					Log.d(TAG, response.body().getTotalPages() + " ");
					mEventBus.post(new IFetchCategorySuccessEvent()
					{
						@Override
						public ProductCategoriesData getProductCategoryData()
						{
							return response.body();
						}
					});
				}
			}
			@Override
			public void onFailure(Call<ProductCategoriesData> call, Throwable t)
			{

				Log.e(TAG, t.getCause().getMessage());
				mEventBus.post(new IFetchCategoryFailEvent()
				{
					@Override
					public NetworkResponseData getNetworkResponseData()
					{
						return new NetworkResponseData(AppController.getInstance().getResources().getString(R.string.data_fetch_error), null, false);
					}
				});
			}
		});
	}


}
