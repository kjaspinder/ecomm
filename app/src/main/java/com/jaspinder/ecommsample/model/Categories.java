package com.jaspinder.ecommsample.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
public class Categories implements Parcelable
{
	private String id;

	private String name;

	private boolean active;

	private String url;

	private List<PathEntity> path;

	private List<SubcategoryEntity> subCategories;

	public Categories(String id, String name, boolean active, String url, List<PathEntity> path, List<SubcategoryEntity> subCategories)
	{
		this.id = id;
		this.name = name;
		this.active = active;
		this.url = url;
		this.path = path;
		this.subCategories = subCategories;
	}

	protected Categories(Parcel in)
	{
		id = in.readString();
		name = in.readString();
		active = in.readByte() != 0;
		url = in.readString();
		path = in.createTypedArrayList(PathEntity.CREATOR);
		subCategories = in.createTypedArrayList(SubcategoryEntity.CREATOR);
	}
	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeString(id);
		dest.writeString(name);
		dest.writeByte((byte) (active ? 1 : 0));
		dest.writeString(url);
		dest.writeTypedList(path);
		dest.writeTypedList(subCategories);
	}
	@Override
	public int describeContents()
	{
		return 0;
	}
	public static final Creator<Categories> CREATOR = new Creator<Categories>()
	{
		@Override
		public Categories createFromParcel(Parcel in)
		{
			return new Categories(in);
		}

		@Override
		public Categories[] newArray(int size)
		{
			return new Categories[size];
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
	public boolean isActive()
	{
		return active;
	}
	public void setActive(boolean active)
	{
		this.active = active;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public List<PathEntity> getPath()
	{
		return path;
	}
	public void setPath(List<PathEntity> path)
	{
		this.path = path;
	}
	public List<SubcategoryEntity> getSubCategories()
	{
		return subCategories;
	}
	public void setSubCategories(List<SubcategoryEntity> subCategories)
	{
		this.subCategories = subCategories;
	}
}
