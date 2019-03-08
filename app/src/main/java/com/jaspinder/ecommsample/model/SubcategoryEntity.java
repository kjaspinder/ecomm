package com.jaspinder.ecommsample.model;


import android.os.Parcel;
import android.os.Parcelable;
public class SubcategoryEntity implements Parcelable
{

	private String id;

	private String name;

	public SubcategoryEntity(String id, String name)
	{
		this.id = id;
		this.name = name;
	}
	protected SubcategoryEntity(Parcel in)
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
	public static final Creator<SubcategoryEntity> CREATOR = new Creator<SubcategoryEntity>()
	{
		@Override
		public SubcategoryEntity createFromParcel(Parcel in)
		{
			return new SubcategoryEntity(in);
		}

		@Override
		public SubcategoryEntity[] newArray(int size)
		{
			return new SubcategoryEntity[size];
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
