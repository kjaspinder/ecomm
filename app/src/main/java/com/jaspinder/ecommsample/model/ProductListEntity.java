package com.jaspinder.ecommsample.model;

import android.os.Parcel;
import android.os.Parcelable;


public class ProductListEntity implements Parcelable
{

	private String sku;
	private CustomerReview customerReviews;
	private Description descriptions;
	private Images images;
	private Names names;
	private Prices prices;
	private Links links;
	private Offers offers;


	public ProductListEntity(String sku, CustomerReview customerReviews, Description descriptions, Images images, Names names, Prices prices, Links links, Offers offers)
	{
		this.sku = sku;
		this.customerReviews = customerReviews;
		this.descriptions = descriptions;
		this.images = images;
		this.names = names;
		this.prices = prices;
		this.links = links;
		this.offers = offers;
	}

	protected ProductListEntity(Parcel in)
	{
		sku = in.readString();
		customerReviews = in.readParcelable(CustomerReview.class.getClassLoader());
		descriptions = in.readParcelable(Description.class.getClassLoader());
		images = in.readParcelable(Images.class.getClassLoader());
		names = in.readParcelable(Names.class.getClassLoader());
		prices = in.readParcelable(Prices.class.getClassLoader());
		links = in.readParcelable(Links.class.getClassLoader());
		offers = in.readParcelable(Offers.class.getClassLoader());
	}
	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeString(sku);
		dest.writeParcelable(customerReviews, flags);
		dest.writeParcelable(descriptions, flags);
		dest.writeParcelable(images, flags);
		dest.writeParcelable(names, flags);
		dest.writeParcelable(prices, flags);
		dest.writeParcelable(links, flags);
		dest.writeParcelable(offers, flags);
	}
	@Override
	public int describeContents()
	{
		return 0;
	}
	public static final Creator<ProductListEntity> CREATOR = new Creator<ProductListEntity>()
	{
		@Override
		public ProductListEntity createFromParcel(Parcel in)
		{
			return new ProductListEntity(in);
		}

		@Override
		public ProductListEntity[] newArray(int size)
		{
			return new ProductListEntity[size];
		}
	};
	public String getSku()
	{
		return sku;
	}
	public void setSku(String sku)
	{
		this.sku = sku;
	}
	public CustomerReview getCustomerReviews()
	{
		return customerReviews;
	}
	public void setCustomerReviews(CustomerReview customerReviews)
	{
		this.customerReviews = customerReviews;
	}
	public Description getDescriptions()
	{
		return descriptions;
	}
	public void setDescriptions(Description descriptions)
	{
		this.descriptions = descriptions;
	}
	public Images getImages()
	{
		return images;
	}
	public void setImages(Images images)
	{
		this.images = images;
	}
	public Names getNames()
	{
		return names;
	}
	public void setNames(Names names)
	{
		this.names = names;
	}
	public Prices getPrices()
	{
		return prices;
	}
	public void setPrices(Prices prices)
	{
		this.prices = prices;
	}
	public Links getLinks()
	{
		return links;
	}
	public void setLinks(Links links)
	{
		this.links = links;
	}
	public Offers getOffers()
	{
		return offers;
	}
	public void setOffers(Offers offers)
	{
		this.offers = offers;
	}
}
