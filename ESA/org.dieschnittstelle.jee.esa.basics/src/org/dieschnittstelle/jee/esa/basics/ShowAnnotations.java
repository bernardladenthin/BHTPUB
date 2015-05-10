package org.dieschnittstelle.jee.esa.basics;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;

import org.dieschnittstelle.jee.esa.basics.annotations.AnnotatedStockItemBuilder;
import org.dieschnittstelle.jee.esa.basics.annotations.DisplayAs;
import org.dieschnittstelle.jee.esa.basics.annotations.StockItemProxyImpl;

public class ShowAnnotations {

	public static void main(String[] args) {
		// we initialise the collection
		StockItemCollection collection = new StockItemCollection(
				"stockitems_annotations.xml", new AnnotatedStockItemBuilder());
		// we load the contents into the collection
		collection.load();

		for (IStockItem consumable : collection.getStockItems()) {
			;
			showAttributes(((StockItemProxyImpl)consumable).getProxiedObject());
		}

		// we initialise a consumer
		Consumer consumer = new Consumer();
		// ... and let them consume
		consumer.doShopping(collection.getStockItems());
	}

	/*
	 * UE BAS2 
	 */
	private static void showAttributes(Object consumable) {
		System.out.println(getClassString(consumable));
	}

	private static String getClassString(Object o) {
		String simpleName = o.getClass().getSimpleName();
		HashMap<String, String> fieldMap = getFieldMap(o);
		String fieldString = getFieldString(fieldMap);
		return "{" + simpleName + " " + fieldString + "}";
	}

	private static String getFieldString(HashMap<String, String> fieldMap) {
		String s = "";
		boolean firstEntry = true;
		for (Entry<String, String> stringStringEntry : fieldMap.entrySet()) {
			if (firstEntry) {
				firstEntry = false;
			} else {
				s += ", ";
			}
			String key = stringStringEntry.getKey();
			String value = stringStringEntry.getValue();
			s += key + ":" + value;
		}
		return s;
	}

	private static HashMap<String, String> getFieldMap(Object consumable) {
		Field[] fields = consumable.getClass().getDeclaredFields();
		HashMap<String, String> attributes = new HashMap<>();
		for (Field f : fields) {
			try {
				
				Method getterMethodFromField = getGetterMethodObject(consumable, f.getName());
				Object getterReturnValue = getterMethodFromField.invoke(consumable);
				
				String key = f.getName();
				// if exist, use the DisplayAs annotation
				String displayAs = getDisplayAsAnnotationIfExist(f);
				if (displayAs != null) {
					key = displayAs;
				}
				
				String value = String.valueOf(getterReturnValue);
				
				attributes.put(key, value);
			} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
				throw new RuntimeException(e);
			}
		}
		return attributes;
	}

	private static Method getGetterMethodObject(Object object, String field) {
		String getterMethodName = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
		try {
			return object.getClass().getDeclaredMethod(getterMethodName);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	private static String getDisplayAsAnnotationIfExist(Field f) {
		Annotation[] annotations = f.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation instanceof DisplayAs) {
				DisplayAs displayAs = (DisplayAs) annotation;
				return displayAs.value();
			}
		}
		return null;
	}

}
