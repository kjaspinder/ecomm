package com.jaspinder.ecommsample.view.commonviews;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.jaspinder.ecommsample.R;
import com.jaspinder.ecommsample.view.fragment.AccountFragment;
import com.jaspinder.ecommsample.view.fragment.HomeFragment;
import com.jaspinder.ecommsample.view.fragment.ProductsFragment;
import com.jaspinder.ecommsample.view.fragment.SearchFragment;

public class BottomTabs extends ConstraintLayout implements View.OnClickListener
{

	Button home;

	Button products;

	Button account;

	Button search;

	private static int mFragmentConatinerId;

	private View v;

	public BottomTabs(Context context)
	{
		super(context);
		init(context);
	}
	public BottomTabs(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		init(context);
	}
	public BottomTabs(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
		init(context);
	}

	private void init(Context context)
	{
		v = LayoutInflater.from(context).inflate(R.layout.bottom_tab_bar, this, true);

	}

	@Override
	protected void onFinishInflate()
	{
		super.onFinishInflate();

		home = v.findViewById(R.id.home);
		products = v.findViewById(R.id.products);
		account = v.findViewById(R.id.account);
		search = v.findViewById(R.id.search);

		home.setOnClickListener(this);
		products.setOnClickListener(this);
		account.setOnClickListener(this);
		search.setOnClickListener(this);
	}
	public void setFragmentcontainerId( int id)
	{
		this.mFragmentConatinerId = id;
	}


	@Override
	public void onClick(View v)
	{
		Fragment fragment = null;
		String tag = null;
		switch (v.getId())
		{
			case R.id.home:
				fragment = HomeFragment.newInstance();
				tag = HomeFragment.TAG;
				break;
			case R.id.products:
				fragment = ProductsFragment.newInstance();
				tag = ProductsFragment.TAG;
				break;
			case R.id.account:
				fragment = AccountFragment.newInstance();
				tag = AccountFragment.TAG;
				break;
			case R.id.search:
				fragment = SearchFragment.newInstance();
				tag = SearchFragment.TAG;
				break;
		}

		FragmentTransaction fragmentTransaction = ((AppCompatActivity)getContext()).getSupportFragmentManager().beginTransaction();
		fragmentTransaction.replace(mFragmentConatinerId,fragment,tag);
		fragmentTransaction.commit();




	}
}
