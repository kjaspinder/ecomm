package com.jaspinder.ecommsample.view.adapter;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaspinder.ecommsample.R;
import com.jaspinder.ecommsample.databinding.ProductListViewItemBinding;
import com.jaspinder.ecommsample.events.IProductListClickListener;
import com.jaspinder.ecommsample.model.ProductListEntity;

public class ProductListAdaptor extends PagedListAdapter<ProductListEntity, ProductListAdaptor.ProductViewHolder>
{
	private Context mContext;

	private IProductListClickListener mIProductListClickListener;

	public ProductListAdaptor(Context context, IProductListClickListener listClickListener)
	{
		super(DIFF_CALLBACK);
		this.mContext = context;
		this.mIProductListClickListener = listClickListener;

	}


	@NonNull
	@Override
	public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
	{
		ProductListViewItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),R.layout.product_list_view_item,viewGroup,false);

		return new ProductViewHolder(binding);
	}
	@Override
	public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i)
	{
		ProductListEntity productListEntity = getItem(i);
		if (productListEntity != null)
		{
			productViewHolder.mProductListViewItemBinding.setModel(productListEntity);

		}
	}

	private static DiffUtil.ItemCallback<ProductListEntity> DIFF_CALLBACK = new DiffUtil.ItemCallback<ProductListEntity>()
	{
		@Override
		public boolean areItemsTheSame(@NonNull ProductListEntity product1, @NonNull ProductListEntity product2)
		{
			return product1.getSku().equals(product2.getSku());
		}
		@Override
		public boolean areContentsTheSame(@NonNull ProductListEntity product1, @NonNull ProductListEntity product2)
		{
			return product1.equals(product2);
		}
	};

	class ProductViewHolder extends RecyclerView.ViewHolder
	{
		public ProductListViewItemBinding mProductListViewItemBinding;

		public ProductViewHolder(@NonNull ProductListViewItemBinding itemRowBinding)
		{
			super(itemRowBinding.getRoot());
			this.mProductListViewItemBinding = itemRowBinding;
		}


	}
}
