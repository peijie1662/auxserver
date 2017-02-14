package Utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class MappingUtil {

	/**
	 * 用大写key的Map<String, Object>给t赋值
	 * 
	 * @author PJ
	 */
	public static <T> void mapToBean(Map<String, Object> map, T t) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Field[] fields = t.getClass().getDeclaredFields();
		Method[] methods = t.getClass().getMethods();
		for (Field field : fields) {
			String fieldName = field.getName().toUpperCase();
			Object fieldValue = map.get(fieldName);
			if (fieldName.endsWith("TIME") || fieldName.endsWith("DATE")) {
				fieldValue = df.format(fieldValue);
				System.out.println("fieldValue:"+fieldValue);
			}
			for (Method method : methods) {
				if (method.getName().toUpperCase().equals("SET" + fieldName)) {
					try {
						if (fieldValue != null) {
							method.invoke(t, fieldValue.toString().trim());
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * 用大写key的List<Map<String,Object>>给List<T>赋值
	 * 
	 * @param sourceList
	 * @param targetList
	 * @param cls
	 * @author PJ
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public static <T> void mapToBeanList(List<Map<String, Object>> sourceList,
			List<T> targetList, Class<?> cls) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		for (Map<String, Object> map : sourceList) {
			T t = (T) Class.forName(cls.getName()).newInstance();
			mapToBean(map, t);
			targetList.add(t);
		}
	}

}
