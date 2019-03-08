package com.jaspinder.ecommsample.events;

import com.jaspinder.ecommsample.model.ProductCategoriesData;
public interface IFetchCategorySuccessEvent
{
	ProductCategoriesData getProductCategoryData();
}
