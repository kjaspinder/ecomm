package com.jaspinder.ecommsample.model;

import android.os.Parcel;
import android.os.Parcelable;
public class Page implements Parcelable
{
	private int current;
	private int size;
	private int total;

	public Page(int current, int size, int total)
	{
		this.current = current;
		this.size = size;
		this.total = total;
	}
	protected Page(Parcel in)
	{
		current = in.readInt();
		size = in.readInt();
		total = in.readInt();
	}
	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeInt(current);
		dest.writeInt(size);
		dest.writeInt(total);
	}
	@Override
	public int describeContents()
	{
		return 0;
	}
	public static final Creator<Page> CREATOR = new Creator<Page>()
	{
		@Override
		public Page createFromParcel(Parcel in)
		{
			return new Page(in);
		}

		@Override
		public Page[] newArray(int size)
		{
			return new Page[size];
		}
	};
	public int getCurrent()
	{
		return current;
	}
	public void setCurrent(int current)
	{
		this.current = current;
	}
	public int getSize()
	{
		return size;
	}
	public void setSize(int size)
	{
		this.size = size;
	}
	public int getTotal()
	{
		return total;
	}
	public void setTotal(int total)
	{
		this.total = total;
	}
}
