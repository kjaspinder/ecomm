package com.jaspinder.ecommsample.view.commonviews;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.jaspinder.ecommsample.R;


public class ProductList extends ConstraintLayout
{
	private View v;

	private RecyclerView productList;

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
	}
}
