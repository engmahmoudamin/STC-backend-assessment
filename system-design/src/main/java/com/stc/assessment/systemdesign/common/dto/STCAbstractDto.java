package com.stc.assessment.systemdesign.common.dto;

import java.io.Serializable;
import java.lang.reflect.Field;

public class STCAbstractDto implements Serializable {
	private static final long serialVersionUID = -1867301712815663019L;

	@Override
	public String toString() {
		StringBuilder classText = new StringBuilder();
		Class<? extends STCAbstractDto> entityClass = this.getClass();
		classText.append("[").append(entityClass.getSimpleName()).append("]").append(" : \n");
		for (Field field : entityClass.getDeclaredFields()) {
			field.setAccessible(true);
			try {
				classText.append(field.getName()).append(" : ").append(field.get(this)).append("\n");
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return classText.toString();
	}
}
