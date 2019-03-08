package com.jaspinder.ecommsample.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
public class ProductListData implements Parcelable
{

	private ResultSet resultSet;
	private Page page;
	private List<ProductListEntity> results;

	public ProductListData(ResultSet resultSet, Page page, List<ProductListEntity> results)
	{
		this.resultSet = resultSet;
		this.page = page;
		this.results = results;
	}
	protected ProductListData(Parcel in)
	{
		resultSet = in.readParcelable(ResultSet.class.getClassLoader());
		page = in.readParcelable(Page.class.getClassLoader());
		results = in.createTypedArrayList(ProductListEntity.CREATOR);
	}
	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeParcelable(resultSet, flags);
		dest.writeParcelable(page, flags);
		dest.writeTypedList(results);
	}
	@Override
	public int describeContents()
	{
		return 0;
	}
	public static final Creator<ProductListData> CREATOR = new Creator<ProductListData>()
	{
		@Override
		public ProductListData createFromParcel(Parcel in)
		{
			return new ProductListData(in);
		}

		@Override
		public ProductListData[] newArray(int size)
		{
			return new ProductListData[size];
		}
	};
	public ResultSet getResultSet()
	{
		return resultSet;
	}
	public void setResultSet(ResultSet resultSet)
	{
		this.resultSet = resultSet;
	}
	public Page getPage()
	{
		return page;
	}
	public void setPage(Page page)
	{
		this.page = page;
	}
	public List<ProductListEntity> getResults()
	{
		return results;
	}
	public void setResults(List<ProductListEntity> results)
	{
		this.results = results;
	}
}
