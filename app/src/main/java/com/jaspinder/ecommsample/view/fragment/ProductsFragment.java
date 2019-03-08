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
import com.jaspinder.ecommsample.view.adapter.CategoryListAdaptor;
import com.jaspinder.ecommsample.view.adapter.SubCategoryListAdaptor;
import com.jaspinder.ecommsample.viewmodel.ProductsFragViewModel;
import com.jaspinder.ecommsample.viewmodel.ViewModelProviderFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
public class ProductsFragment extends Fragment implements ICategoryListClickListener
{

	@BindView(R.id.categoryList)
	RecyclerView categoryList;

	@BindView(R.id.subCategoryList)
	RecyclerView subCategoryList;


	public static final String TAG = "ProductsFragment";

	private ProductsFragViewModel mProductsFragViewModel;

	CategoryListAdaptor adaptor;
	SubCategoryListAdaptor mSubCategoryListAdaptor;

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
		ButterKnife.bind(this,v);



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

		subCategoryList.setLayoutManager(new LinearLayoutManager(getActivity()));

		adaptor = new CategoryListAdaptor(getActivity(),this);
		mSubCategoryListAdaptor = new SubCategoryListAdaptor(getActivity(),null);

		mProductsFragViewModel.getCategoriesPageList().removeObserver(categoriesPagedListObserver);
		mProductsFragViewModel.getCategoriesPageList().observe(this,categoriesPagedListObserver);

		categoryList.setAdapter(adaptor);
		subCategoryList.setAdapter(adaptor);

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


	@Override
	public void onClick(Categories categories)
	{
		showSubCategoryList();
		mSubCategoryListAdaptor = new SubCategoryListAdaptor(getActivity(),categories.getSubCategories());
		subCategoryList.setAdapter(mSubCategoryListAdaptor);
	}

	private void showSubCategoryList()
	{
		subCategoryList.setVisibility(View.VISIBLE);
		categoryList.setVisibility(View.GONE);
	}

	private void showCategoryList()
	{
		subCategoryList.setVisibility(View.GONE);
		categoryList.setVisibility(View.VISIBLE);
	}


}