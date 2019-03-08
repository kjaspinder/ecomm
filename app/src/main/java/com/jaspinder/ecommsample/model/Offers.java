package com.jaspinder.ecommsample.model;

import android.os.Parcel;
import android.os.Parcelable;
public class Offers implements Parcelable
{

	private Prices prices;
	private String condition;
	private boolean onlineAvailability;
	private boolean inStoreAvailability;
	private String listingId;
	private String sellerId;

	public Offers(Prices prices, String condition, boolean onlineAvailability, boolean inStoreAvailability, String listingId, String sellerId)
	{
		this.prices = prices;
		this.condition = condition;
		this.onlineAvailability = onlineAvailability;
		this.inStoreAvailability = inStoreAvailability;
		this.listingId = listingId;
		this.sellerId = sellerId;
	}

	protected Offers(Parcel in)
	{
		prices = in.readParcelable(Prices.class.getClassLoader());
		condition = in.readString();
		onlineAvailability = in.readByte() != 0;
		inStoreAvailability = in.readByte() != 0;
		listingId = in.readString();
		sellerId = in.readString();
	}
	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeParcelable(prices, flags);
		dest.writeString(condition);
		dest.writeByte((byte) (onlineAvailability ? 1 : 0));
		dest.writeByte((byte) (inStoreAvailability ? 1 : 0));
		dest.writeString(listingId);
		dest.writeString(sellerId);
	}
	@Override
	public int describeContents()
	{
		return 0;
	}
	public static final Creator<Offers> CREATOR = new Creator<Offers>()
	{
		@Override
		public Offers createFromParcel(Parcel in)
		{
			return new Offers(in);
		}

		@Override
		public Offers[] newArray(int size)
		{
			return new Offers[size];
		}
	};
	public Prices getPrices()
	{
		return prices;
	}
	public void setPrices(Prices prices)
	{
		this.prices = prices;
	}
	public String getCondition()
	{
		return condition;
	}
	public void setCondition(String condition)
	{
		this.condition = condition;
	}
	public boolean isOnlineAvailability()
	{
		return onlineAvailability;
	}
	public void setOnlineAvailability(boolean onlineAvailability)
	{
		this.onlineAvailability = onlineAvailability;
	}
	public boolean isInStoreAvailability()
	{
		return inStoreAvailability;
	}
	public void setInStoreAvailability(boolean inStoreAvailability)
	{
		this.inStoreAvailability = inStoreAvailability;
	}
	public String getListingId()
	{
		return listingId;
	}
	public void setListingId(String listingId)
	{
		this.listingId = listingId;
	}
	public String getSellerId()
	{
		return sellerId;
	}
	public void setSellerId(String sellerId)
	{
		this.sellerId = sellerId;
	}
}
