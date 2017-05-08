package ru.codeseeker.persistence.json;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.usertype.DynamicParameterizedType;

import java.util.Properties;

public class JsonType
	extends AbstractSingleColumnStandardBasicType<Object> implements DynamicParameterizedType {

	public JsonType() {
		super( JsonSqlTypeDescriptor.INSTANCE, new JsonTypeDescriptor());
	}

	public String getName() {
		return "jsonb";
	}

	@Override
	public void setParameterValues(Properties parameters) {
		((JsonTypeDescriptor) getJavaTypeDescriptor()).setParameterValues(parameters);
	}

}