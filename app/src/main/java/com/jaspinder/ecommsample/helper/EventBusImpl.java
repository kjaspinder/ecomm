package com.jaspinder.ecommsample.helper;

import org.greenrobot.eventbus.EventBus;
public class EventBusImpl implements IEventBus
{

	private static EventBusImpl sEventBusImpl = new EventBusImpl();

	private final EventBus mEventBus;

	private final IBusinessExecutor mBusinessExecutor;

	public static EventBusImpl getInstance() {
		return sEventBusImpl;
	}
	private EventBusImpl() {
		mEventBus = EventBus.builder()
				.sendNoSubscriberEvent(false)
				.throwSubscriberException(true)
				.logNoSubscriberMessages(false).build();
		mBusinessExecutor = BusinessExecutor.getInstance();
	}

	@Override
	public void register(Object subscriber) throws NullPointerException
	{
		mEventBus.register(subscriber);
	}
	@Override
	public void unregister(Object subscriber) throws NullPointerException
	{
		mEventBus.unregister(subscriber);
	}
	@Override
	public void postByBusinessThread(final Object event)
	{
		mBusinessExecutor.executeInBusinessThread(new Runnable() {
			@Override
			public void run() {
				mEventBus.post(event);
			}
		});
	}
	@Override
	public void post(Object event)
	{
		mEventBus.post(event);
	}
}
