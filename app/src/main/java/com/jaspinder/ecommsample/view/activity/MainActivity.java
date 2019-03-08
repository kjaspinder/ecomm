package com.jaspinder.ecommsample.view.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.jaspinder.ecommsample.R;
import com.jaspinder.ecommsample.databinding.MainActivityBinding;
import com.jaspinder.ecommsample.view.commonviews.BottomTabs;
import com.jaspinder.ecommsample.view.fragment.HomeFragment;
import com.jaspinder.ecommsample.viewmodel.ViewModelProviderFactory;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
{

	@BindView(R.id.fragmentContainer)
	FrameLayout fragmentContainer;

	private MainActivityBinding binding;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);


		binding = DataBindingUtil.setContentView(this,R.layout.main_activity);

		ButterKnife.bind(this);

		BottomTabs tabs = new BottomTabs(this);
		tabs.setFragmentcontainerId(R.id.fragmentContainer);
		tabs.setDataBinding(binding);


		goToHomeFragment();
	}

	private void goToHomeFragment()
	{
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.replace(R.id.fragmentContainer, HomeFragment.newInstance(),HomeFragment.TAG);
		fragmentTransaction.commit();
	}
}
