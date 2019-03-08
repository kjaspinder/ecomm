package com.jaspinder.ecommsample.model;

import android.os.Parcel;
import android.os.Parcelable;
public class Prices implements Parcelable
{
	private float regular;
	private float current;

	public Prices(float regular, float current)
	{
		this.regular = regular;
		this.current = current;
	}

	protected Prices(Parcel in)
	{
		regular = in.readFloat();
		current = in.readFloat();
	}
	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeFloat(regular);
		dest.writeFloat(current);
	}
	@Override
	public int describeContents()
	{
		return 0;
	}
	public static final Creator<Prices> CREATOR = new Creator<Prices>()
	{
		@Override
		public Prices createFromParcel(Parcel in)
		{
			return new Prices(in);
		}

		@Override
		public Prices[] newArray(int size)
		{
			return new Prices[size];
		}
	};
	public float getRegular()
	{
		return regular;
	}
	public void setRegular(float regular)
	{
		this.regular = regular;
	}
	public float getCurrent()
	{
		return current;
	}
	public void setCurrent(float current)
	{
		this.current = current;
	}
}
