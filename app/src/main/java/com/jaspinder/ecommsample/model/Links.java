package com.jaspinder.ecommsample.model;

import android.os.Parcel;
import android.os.Parcelable;
public class Links implements Parcelable
{

	private String product;
	private String web;
	private String addToCart;


	public Links(String product, String web, String addToCart)
	{
		this.product = product;
		this.web = web;
		this.addToCart = addToCart;
	}

	protected Links(Parcel in)
	{
		product = in.readString();
		web = in.readString();
		addToCart = in.readString();
	}
	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeString(product);
		dest.writeString(web);
		dest.writeString(addToCart);
	}
	@Override
	public int describeContents()
	{
		return 0;
	}
	public static final Creator<Links> CREATOR = new Creator<Links>()
	{
		@Override
		public Links createFromParcel(Parcel in)
		{
			return new Links(in);
		}

		@Override
		public Links[] newArray(int size)
		{
			return new Links[size];
		}
	};
	public String getProduct()
	{
		return product;
	}
	public void setProduct(String product)
	{
		this.product = product;
	}
	public String getWeb()
	{
		return web;
	}
	public void setWeb(String web)
	{
		this.web = web;
	}
	public String getAddToCart()
	{
		return addToCart;
	}
	public void setAddToCart(String addToCart)
	{
		this.addToCart = addToCart;
	}
}
