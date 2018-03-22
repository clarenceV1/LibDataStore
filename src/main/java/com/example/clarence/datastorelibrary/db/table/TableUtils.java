
package com.example.clarence.datastorelibrary.db.table;

import com.example.clarence.datastorelibrary.db.annotation.Column;
import com.example.clarence.datastorelibrary.db.converter.ColumnConverterFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedHashMap;

final class TableUtils {
    static String tag = "TableUtils";

    private TableUtils() {
    }

    /* package */
    static synchronized LinkedHashMap<String, ColumnEntity> findColumnMap(Class<?> entityType) {
        LinkedHashMap<String, ColumnEntity> columnMap = new LinkedHashMap<String, ColumnEntity>();
        addColumns2Map(entityType, columnMap);
        return columnMap;
    }

    private static void addColumns2Map(Class<?> entityType, HashMap<String, ColumnEntity> columnMap) {
        if (Object.class.equals(entityType)) return;

        try {
            Field[] fields = entityType.getDeclaredFields();
            for (Field field : fields) {
                int modify = field.getModifiers();
                if (Modifier.isStatic(modify) || Modifier.isTransient(modify)) {
                    continue;
                }
                Column columnAnn = field.getAnnotation(Column.class);
                if (columnAnn != null) {
                    if (ColumnConverterFactory.isSupportColumnConverter(field.getType())) {
                        ColumnEntity column = new ColumnEntity(entityType, field, columnAnn);
                        if (!columnMap.containsKey(column.getName())) {
                            columnMap.put(column.getName(), column);
                        }
                    }
                }
            }

            addColumns2Map(entityType.getSuperclass(), columnMap);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
