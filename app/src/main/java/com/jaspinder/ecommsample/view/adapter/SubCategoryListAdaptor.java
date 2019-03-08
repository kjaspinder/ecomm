package com.jaspinder.ecommsample.view.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaspinder.ecommsample.R;
import com.jaspinder.ecommsample.model.SubcategoryEntity;

import java.util.ArrayList;
import java.util.List;
public class SubCategoryListAdaptor extends RecyclerView.Adapter<SubCategoryListAdaptor.ViewHolder>
{
	private Context ctx;
	private List<SubcategoryEntity> mSubcategoryEntityList;

	public SubCategoryListAdaptor(Context context, List<SubcategoryEntity> subcategoryEntityList)
	{
		this.ctx = context;
		this.mSubcategoryEntityList = subcategoryEntityList;
	}

	public void updateData(List<SubcategoryEntity> subcategoryEntityList){
		if(mSubcategoryEntityList == null){
			mSubcategoryEntityList = new ArrayList<>();
			mSubcategoryEntityList.addAll(subcategoryEntityList);
			return;
		}
		mSubcategoryEntityList.clear();
		mSubcategoryEntityList.addAll(subcategoryEntityList);

	}


	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
	{
		View v = LayoutInflater.from(ctx).inflate(R.layout.category_list_view_item, viewGroup, false);

		return new ViewHolder(v);
	}
	@Override
	public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
	{
		final SubcategoryEntity subcategoryEntity = mSubcategoryEntityList.get(i);

		if(subcategoryEntity != null){
			viewHolder.mTextView.setText(subcategoryEntity.getName());
		}
	}
	@Override
	public int getItemCount()
	{
		if(mSubcategoryEntityList == null){
			return 0;
		}
		return mSubcategoryEntityList.size();
	}
	class ViewHolder extends RecyclerView.ViewHolder
	{
		TextView mTextView;
		public ViewHolder(@NonNull View itemView)
		{
			super(itemView);

			mTextView = itemView.findViewById(R.id.categoryName);
		}
	}

}
