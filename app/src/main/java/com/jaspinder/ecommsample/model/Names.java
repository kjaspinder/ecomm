package com.jaspinder.ecommsample.model;

import android.os.Parcel;
import android.os.Parcelable;
public class Names implements Parcelable
{

	private String title;

	public Names(String title)
	{
		this.title = title;
	}
	protected Names(Parcel in)
	{
		title = in.readString();
	}
	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeString(title);
	}
	@Override
	public int describeContents()
	{
		return 0;
	}
	public static final Creator<Names> CREATOR = new Creator<Names>()
	{
		@Override
		public Names createFromParcel(Parcel in)
		{
			return new Names(in);
		}

		@Override
		public Names[] newArray(int size)
		{
			return new Names[size];
		}
	};
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
}
