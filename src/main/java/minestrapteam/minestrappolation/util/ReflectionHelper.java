package minestrapteam.minestrappolation.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionHelper {
	
	public static Method[] getMethods(Class clazz)
	{
		Method[] methods = clazz.getMethods();
		for(Method m: methods)
		{
			System.out.println(m.getName());
		}
		return methods;
	}
	
	
	public static Object invokeObject(Class clazz, String method, Class[] param, Object...args)
	{
		Class c = clazz;
		try {
			Object obj = c.newInstance();
			Method m = c.getDeclaredMethod(method, param);
			m.setAccessible(true);
			return m.invoke(obj, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Field[] getFields(Class clazz)
	{
		Field[] methods = clazz.getFields();
		for(Field f: methods)
		{
			System.out.println(f.getName());
		}
		return methods;
	}
	
	public static Field getField(Class clazz, String field)
	{
		try 
		{
			Object obj = clazz.newInstance();
			Field f = obj.getClass().getDeclaredField(field);
			f.setAccessible(true);
			return f;
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static void setField(Class clazz, Object obj, String field, Object value)
	{
		try 
		{
			Field f = getField(clazz, field);
			f.set(obj, value);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static <T> T getValue(Class clazz, String field)
	{
		try {
			Object obj = clazz.newInstance();
			Field f = getField(clazz, field);
			return (T)f.get(obj);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
