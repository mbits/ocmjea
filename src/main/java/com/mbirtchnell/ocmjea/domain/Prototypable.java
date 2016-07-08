package com.mbirtchnell.ocmjea.domain;

public interface Prototypable<T> extends Cloneable
{
	public T clone(Class<? extends T> clazz);
}