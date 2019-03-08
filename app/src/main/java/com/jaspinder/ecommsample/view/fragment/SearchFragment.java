package com.jaspinder.ecommsample.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaspinder.ecommsample.R;

public class SearchFragment extends Fragment
{
	public static final String TAG = "SearchFragment";

	public static SearchFragment newInstance()
	{
		SearchFragment frag = new SearchFragment();

		return frag;
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		View v = getActivity().getLayoutInflater().inflate(R.layout.search_fragment,null);
		return v;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
	}
}
