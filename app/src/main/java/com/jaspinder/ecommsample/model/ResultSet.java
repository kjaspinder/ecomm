package com.jaspinder.ecommsample.model;

import android.os.Parcel;
import android.os.Parcelable;
public class ResultSet implements Parcelable
{
	private int count;

	public ResultSet(int count)
	{
		this.count = count;
	}
	protected ResultSet(Parcel in)
	{
		count = in.readInt();
	}
	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeInt(count);
	}
	@Override
	public int describeContents()
	{
		return 0;
	}
	public static final Creator<ResultSet> CREATOR = new Creator<ResultSet>()
	{
		@Override
		public ResultSet createFromParcel(Parcel in)
		{
			return new ResultSet(in);
		}

		@Override
		public ResultSet[] newArray(int size)
		{
			return new ResultSet[size];
		}
	};
	public int getCount()
	{
		return count;
	}
	public void setCount(int count)
	{
		this.count = count;
	}
}
