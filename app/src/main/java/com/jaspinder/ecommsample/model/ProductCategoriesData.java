package com.jaspinder.ecommsample.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
public class ProductCategoriesData implements Parcelable
{
	private int from;
	private int to;
	private int currentPage;
	private int total;
	private int totalPages;
	private List<Categories> categories;

	public ProductCategoriesData(int from, int to, int currentPage, int total, int totalPages, List<Categories> categories)
	{
		this.from = from;
		this.to = to;
		this.currentPage = currentPage;
		this.total = total;
		this.totalPages = totalPages;
		this.categories = categories;
	}

	protected ProductCategoriesData(Parcel in)
	{
		from = in.readInt();
		to = in.readInt();
		currentPage = in.readInt();
		total = in.readInt();
		totalPages = in.readInt();
		categories = in.createTypedArrayList(Categories.CREATOR);
	}
	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeInt(from);
		dest.writeInt(to);
		dest.writeInt(currentPage);
		dest.writeInt(total);
		dest.writeInt(totalPages);
		dest.writeTypedList(categories);
	}
	@Override
	public int describeContents()
	{
		return 0;
	}
	public static final Creator<ProductCategoriesData> CREATOR = new Creator<ProductCategoriesData>()
	{
		@Override
		public ProductCategoriesData createFromParcel(Parcel in)
		{
			return new ProductCategoriesData(in);
		}

		@Override
		public ProductCategoriesData[] newArray(int size)
		{
			return new ProductCategoriesData[size];
		}
	};
	public int getFrom()
	{
		return from;
	}
	public void setFrom(int from)
	{
		this.from = from;
	}
	public int getTo()
	{
		return to;
	}
	public void setTo(int to)
	{
		this.to = to;
	}
	public int getCurrentPage()
	{
		return currentPage;
	}
	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}
	public int getTotal()
	{
		return total;
	}
	public void setTotal(int total)
	{
		this.total = total;
	}
	public int getTotalPages()
	{
		return totalPages;
	}
	public void setTotalPages(int totalPages)
	{
		this.totalPages = totalPages;
	}
	public List<Categories> getCategories()
	{
		return categories;
	}
	public void setCategories(List<Categories> categories)
	{
		this.categories = categories;
	}
}
