package com.jaspinder.ecommsample.helper;

import com.jaspinder.ecommsample.model.ProductCategoriesData;
import com.jaspinder.ecommsample.model.ProductListData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
public interface RetrofitCalls
{

	@GET(AppConstants.all_categories)
	Call<ProductCategoriesData> getCategoriesData(@Query("format") String format,@Query("pageSize") int pageSize,@Query("page") int page,@Query("apiKey")String apiKey);

	@GET(AppConstants.products)
	Call<ProductListData> getProductListData(@Path("categoryId") String categoryId, @Query("pageSize") int pageSize, @Query("page") int page, @Query("apiKey")String apiKey);
}
