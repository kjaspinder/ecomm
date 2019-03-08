package com.jaspinder.ecommsample.model;

import android.os.Parcel;
import android.os.Parcelable;
public class Description implements Parcelable
{

	private String shortDescription;


	protected Description(Parcel in)
	{
		shortDescription = in.readString();
	}
	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeString(shortDescription);
	}
	@Override
	public int describeContents()
	{
		return 0;
	}
	public static final Creator<Description> CREATOR = new Creator<Description>()
	{
		@Override
		public Description createFromParcel(Parcel in)
		{
			return new Description(in);
		}

		@Override
		public Description[] newArray(int size)
		{
			return new Description[size];
		}
	};
	public String getShortDescription()
	{
		return shortDescription;
	}
	public void setShortDescription(String shortDescription)
	{
		this.shortDescription = shortDescription;
	}
}
