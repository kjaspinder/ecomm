package com.jaspinder.ecommsample.model;

import android.os.Parcel;
import android.os.Parcelable;
public class CustomerReview implements Parcelable
{

	private double averageScore;
	private long count;

	public CustomerReview(double averageScore, long count)
	{
		this.averageScore = averageScore;
		this.count = count;
	}

	protected CustomerReview(Parcel in)
	{
		averageScore = in.readDouble();
		count = in.readLong();
	}
	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeDouble(averageScore);
		dest.writeLong(count);
	}
	@Override
	public int describeContents()
	{
		return 0;
	}
	public static final Creator<CustomerReview> CREATOR = new Creator<CustomerReview>()
	{
		@Override
		public CustomerReview createFromParcel(Parcel in)
		{
			return new CustomerReview(in);
		}

		@Override
		public CustomerReview[] newArray(int size)
		{
			return new CustomerReview[size];
		}
	};
	public double getAverageScore()
	{
		return averageScore;
	}
	public void setAverageScore(double averageScore)
	{
		this.averageScore = averageScore;
	}
	public long getCount()
	{
		return count;
	}
	public void setCount(long count)
	{
		this.count = count;
	}
}
