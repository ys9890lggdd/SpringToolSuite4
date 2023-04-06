package com.itwill.annotation;

@MarkerAnnotation
public class MarkerAnnotationPlacement {
	@MarkerAnnotation
	String field;
	@MarkerAnnotation
	public void method1(@MarkerAnnotation String str) {
		@MarkerAnnotation
		String test;
	}
}