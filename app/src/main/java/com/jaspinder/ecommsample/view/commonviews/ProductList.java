package com.jaspinder.ecommsample.view.commonviews;

import android.arch.paging.PagedList;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.jaspinder.ecommsample.R;
import com.jaspinder.ecommsample.events.IProductListClickListener;
import com.jaspinder.ecommsample.model.ProductListEntity;
import com.jaspinder.ecommsample.view.adapter.ProductListAdaptor;

import java.util.ArrayList;
import java.util.List;


public class ProductList extends ConstraintLayout implements IProductListClickListener
{
	private View v;

	private RecyclerView productList;


	private ProductListAdaptor mProductListAdaptor;

	public ProductList(Context context)
	{
		super(context);
		init(context);
	}
	public ProductList(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}
	public ProductList(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
	}

	public void init(Context c)
	{

		v = LayoutInflater.from(c).inflate(R.layout.products_fragment, this, true);
	}

	@Override
	protected void onFinishInflate()
	{
		super.onFinishInflate();

		productList = v.findViewById(R.id.categoryList);
		productList.setLayoutManager(new LinearLayoutManager(getContext()));

		mProductListAdaptor = new ProductListAdaptor(getContext(),this);
		productList.setAdapter(mProductListAdaptor);

	}

	public void setProductList(PagedList<ProductListEntity> productListEntities)
	{
		mProductListAdaptor.submitList(productListEntities);
		mProductListAdaptor.notifyDataSetChanged();
	}


	@Override
	public void onClick(ProductListEntity categories)
	{

	}
}
