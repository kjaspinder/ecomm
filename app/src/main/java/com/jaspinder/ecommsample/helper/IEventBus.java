package com.jaspinder.ecommsample.helper;

public interface IEventBus
{

	public void register(Object subscriber) throws NullPointerException;
	public void unregister(Object subscriber) throws NullPointerException;
	void postByBusinessThread(Object event);
	public void post(Object event);
}
