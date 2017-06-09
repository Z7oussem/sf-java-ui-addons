package io.asfjava.ui.extensions.schema.decorators;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.types.StringSchema;

import io.asfjava.ui.extensions.forms.DatePicker;
import io.asfjava.ui.schema.decorator.SchemaDecorator;

public class DatePickerSchemaDecorator implements SchemaDecorator {

	public void customizeSchema(BeanProperty property, JsonSchema jsonschema) {
		DatePicker annotation = property.getAnnotation(DatePicker.class);
		if (annotation != null) {
			if (annotation.title() != null) {
				((StringSchema) jsonschema).setTitle(annotation.title());
			}
			((StringSchema) jsonschema).setFormat(JsonValueFormat.DATE);
		}
	}

	public String getAnnotation() {
		return DatePicker.class.getName();
	}
}