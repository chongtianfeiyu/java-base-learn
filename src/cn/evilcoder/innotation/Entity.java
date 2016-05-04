package cn.evilcoder.innotation;

import java.lang.reflect.Field;

/**
 * Created by huangshanqi on 2016/5/4.
 */
public class Entity {

    public String entityInfo(){
        StringBuffer sb = new StringBuffer();
        sb.append("Entity Info:").append("\n");

        Class entity = this.getClass();

        //get database info
        if(entity.isAnnotationPresent(Database.class)){
            Database database = (Database) entity.getAnnotation(Database.class);
            sb.append("database:").append(database.value()).append("\n");
        }else{
            sb.append("Missing database name!");
            return sb.toString();
        }

        //get the table info
        if(entity.isAnnotationPresent(Table.class)){
            Table table = (Table) entity.getAnnotation(Table.class);
            sb.append("table:").append(table.value()).append("\n");
        }else{
            sb.append("Missing table name!");
            return sb.toString();
        }

        //get column info
        sb.append("[").append("\n");
        Field[] fields = entity.getDeclaredFields();
        for(Field field:fields){
            if(field.isAnnotationPresent(Column.class)){
                Column column = (Column) field.getAnnotation(Column.class);
                sb.append(column.value()).append(":");
                field.setAccessible(true);
                try {
                    sb.append(field.get(this)).append("\n");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        sb.append("]").append("\n");
        return sb.toString();
    }
}
