package com.stc.assessment.systemdesign.common.entity;

import java.io.Serializable;
import java.lang.reflect.Field;

public abstract class STCAbstractEntity<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = -8221482602567982295L;

    @Override
    public String toString() {
        StringBuilder classText = new StringBuilder();
        Class<? extends STCAbstractEntity> entityClass = this.getClass();
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

    public abstract ID loadId();

    public ID loadId(Class<ID> pkClass) {
        ID id = null;
        try {
            id = pkClass.newInstance();
            Class<? extends STCAbstractEntity> entityClass = this.getClass();
            for (Field field : pkClass.getDeclaredFields()) {
                Field entityField = entityClass.getDeclaredField(field.getName());
                entityField.setAccessible(true);
                Object entityFieldValue = entityField.get(this);
                field.setAccessible(true);
                field.set(id, entityFieldValue);
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return id;
    }

}
