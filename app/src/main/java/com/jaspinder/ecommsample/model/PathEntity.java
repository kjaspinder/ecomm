package com.jaspinder.ecommsample.model;

import android.os.Parcel;
import android.os.Parcelable;
public class PathEntity implements Parcelable
{

	private String id;

	private String name;

	public PathEntity(String id, String name)
	{
		this.id = id;
		this.name = name;
	}
	protected PathEntity(Parcel in)
	{
		id = in.readString();
		name = in.readString();
	}
	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeString(id);
		dest.writeString(name);
	}
	@Override
	public int describeContents()
	{
		return 0;
	}
	public static final Creator<PathEntity> CREATOR = new Creator<PathEntity>()
	{
		@Override
		public PathEntity createFromParcel(Parcel in)
		{
			return new PathEntity(in);
		}

		@Override
		public PathEntity[] newArray(int size)
		{
			return new PathEntity[size];
		}
	};
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
}
