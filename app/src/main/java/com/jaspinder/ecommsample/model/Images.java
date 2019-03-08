package com.jaspinder.ecommsample.model;

import android.os.Parcel;
import android.os.Parcelable;
public class Images implements Parcelable
{
	private  String standard;

	public Images(String standard)
	{
		this.standard = standard;
	}
	protected Images(Parcel in)
	{
		standard = in.readString();
	}
	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeString(standard);
	}
	@Override
	public int describeContents()
	{
		return 0;
	}
	public static final Creator<Images> CREATOR = new Creator<Images>()
	{
		@Override
		public Images createFromParcel(Parcel in)
		{
			return new Images(in);
		}

		@Override
		public Images[] newArray(int size)
		{
			return new Images[size];
		}
	};
	public String getStandard()
	{
		return standard;
	}
	public void setStandard(String standard)
	{
		this.standard = standard;
	}
}
