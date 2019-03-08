package com.jaspinder.ecommsample.helper;

import java.util.concurrent.Future;
public interface IBusinessExecutor
{
	public void executeInBusinessThread(Runnable command) throws NullPointerException;

	public void executeInResourceThread(Runnable command) throws NullPointerException;

	Future submitInResourceThread(Runnable command) throws NullPointerException;

	Future submitInSessionResourceThread(Runnable command) throws NullPointerException;

}
