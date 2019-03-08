package com.jaspinder.ecommsample.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaspinder.ecommsample.R;
public class AccountFragment extends Fragment
{
	public static final String TAG = "AccountFragment";

	public static AccountFragment newInstance()
	{
		AccountFragment frag = new AccountFragment();

		return frag;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
	}
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		View v = getActivity().getLayoutInflater().inflate(R.layout.account_fragment,null);
		return v;
	}
}


