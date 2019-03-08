package com.jaspinder.ecommsample.view.adapter;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaspinder.ecommsample.R;
import com.jaspinder.ecommsample.events.ICategoryListClickListener;
import com.jaspinder.ecommsample.model.Categories;


public class CategoryListAdaptor extends PagedListAdapter<Categories, CategoryListAdaptor.CategoryViewHolder>
{

	private Context mContext;

	private ICategoryListClickListener mICategoryListClickListener;

	public CategoryListAdaptor(Context context, ICategoryListClickListener listClickListener)
	{
		super(DIFF_CALLBACK);
		this.mContext = context;
		this.mICategoryListClickListener = listClickListener;

	}
	@NonNull
	@Override
	public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
	{
		View v = LayoutInflater.from(mContext).inflate(R.layout.category_list_view_item, viewGroup, false);

		return new CategoryViewHolder(v);
	}
	@Override
	public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i)
	{
		final Categories categories = getItem(i);
		if (categories != null)
		{
			categoryViewHolder.mTextView.setText(categories.getName());

			categoryViewHolder.mTextView.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					mICategoryListClickListener.onClick(categories);
				}
			});
		}
	}


	private static DiffUtil.ItemCallback<Categories> DIFF_CALLBACK = new DiffUtil.ItemCallback<Categories>()
	{
		@Override
		public boolean areItemsTheSame(@NonNull Categories categories, @NonNull Categories t1)
		{
			return categories.getId().equals(t1.getId());
		}
		@Override
		public boolean areContentsTheSame(@NonNull Categories categories, @NonNull Categories t1)
		{
			return categories.equals(t1);
		}
	};

	class CategoryViewHolder extends RecyclerView.ViewHolder
	{
		TextView mTextView;
		public CategoryViewHolder(@NonNull View itemView)
		{
			super(itemView);

			mTextView = itemView.findViewById(R.id.categoryName);
		}
	}
}
