package com.jaspinder.ecommsample.view.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaspinder.ecommsample.R;
import com.jaspinder.ecommsample.events.ICategoryListClickListener;
import com.jaspinder.ecommsample.model.Categories;
import com.jaspinder.ecommsample.model.ProductListData;
import com.jaspinder.ecommsample.model.ProductListEntity;
import com.jaspinder.ecommsample.view.adapter.CategoryListAdaptor;
import com.jaspinder.ecommsample.view.adapter.SubCategoryListAdaptor;
import com.jaspinder.ecommsample.view.commonviews.ProductList;
import com.jaspinder.ecommsample.viewmodel.ProductsFragViewModel;
import com.jaspinder.ecommsample.viewmodel.ViewModelProviderFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
public class ProductsFragment extends Fragment implements ICategoryListClickListener
{

	@BindView(R.id.categoryList)
	RecyclerView categoryList;

	@BindView(R.id.productsList)
	ProductList mProductList;

	private ProductList productList;




	public static final String TAG = "ProductsFragment";

	private ProductsFragViewModel mProductsFragViewModel;

	CategoryListAdaptor adaptor;



	public static ProductsFragment newInstance()
	{
		ProductsFragment frag = new ProductsFragment();

		return frag;
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		View v = getActivity().getLayoutInflater().inflate(R.layout.products_fragment, null);
		ButterKnife.bind(this, v);

		productList = new ProductList(getActivity());
		return v;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);

		ViewModelProviderFactory factory = ViewModelProviderFactory.getInstance();
		mProductsFragViewModel = ViewModelProviders.of(this, factory).get(ProductsFragViewModel.class);
		getLifecycle().addObserver(mProductsFragViewModel);
	}

	@Override
	public void onResume()
	{
		super.onResume();

		categoryList.setLayoutManager(new LinearLayoutManager(getActivity()));
		categoryList.setHasFixedSize(true);


		adaptor = new CategoryListAdaptor(getActivity(), this);

		mProductsFragViewModel.getCategoriesPageList().removeObserver(categoriesPagedListObserver);
		mProductsFragViewModel.getCategoriesPageList().observe(this, categoriesPagedListObserver);

		mProductsFragViewModel.getProductPagedList().removeObserver(productPagedListObserver);
		mProductsFragViewModel.getProductPagedList().observe(this,productPagedListObserver);

		categoryList.setAdapter(adaptor);

	}


	private final Observer<PagedList<Categories>> categoriesPagedListObserver = new Observer<PagedList<Categories>>()
	{
		@Override
		public void onChanged(@Nullable PagedList<Categories> categories)
		{
			adaptor.submitList(categories);
			adaptor.notifyDataSetChanged();
		}
	};

	private final Observer<PagedList<ProductListEntity>> productPagedListObserver = new Observer<PagedList<ProductListEntity>>()
	{
		@Override
		public void onChanged(@Nullable PagedList<ProductListEntity> products)
		{
			productList.setProductList(products);
		}
	};


	@Override
	public void onClick(Categories categories)
	{
		//fetch products for selected category
		mProductsFragViewModel.getProductsForSelectedCategory(categories.getId());

	}




}