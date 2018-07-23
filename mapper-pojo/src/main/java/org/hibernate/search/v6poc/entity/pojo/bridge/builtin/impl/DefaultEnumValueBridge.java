/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.v6poc.entity.pojo.bridge.builtin.impl;

import org.hibernate.search.v6poc.backend.document.model.dsl.IndexSchemaFieldContext;
import org.hibernate.search.v6poc.backend.document.model.dsl.IndexSchemaFieldTypedContext;
import org.hibernate.search.v6poc.entity.pojo.bridge.IdentifierBridge;
import org.hibernate.search.v6poc.entity.pojo.bridge.ValueBridge;
import org.hibernate.search.v6poc.entity.pojo.model.PojoModelValue;
import org.hibernate.search.v6poc.util.AssertionFailure;

public final class DefaultEnumValueBridge<T extends Enum<T>> implements IdentifierBridge<T>, ValueBridge<T, String> {

	private Class<T> enumType;

	@Override
	public void close() {
		// Nothing to do
	}

	@Override
	@SuppressWarnings("unchecked") // The mapper does part of the checks using reflection, and we do the rest in this method
	public void bind(PojoModelValue<T> pojoModelValue) {
		this.enumType = (Class<T>) pojoModelValue.getRawType();
		if ( enumType.equals( Enum.class ) ) {
			throw new AssertionFailure(
					"Bridge " + this + " bound to type Enum instead of an actual enum type."
							+ " There is a bug in Hibernate Search, please report it."
			);
		}
	}

	@Override
	public IndexSchemaFieldTypedContext<String> bind(PojoModelValue<T> pojoModelValue,
			IndexSchemaFieldContext fieldContext) {
		bind( pojoModelValue );
		return fieldContext.asString();
	}

	@Override
	public String toDocumentIdentifier(T propertyValue) {
		return toIndexedValue( propertyValue );
	}

	@Override
	public T fromDocumentIdentifier(String documentIdentifier) {
		return fromIndexedValue( documentIdentifier );
	}

	@Override
	public String toIndexedValue(T value) {
		return value == null ? null : value.name();
	}

	@Override
	public T fromIndexedValue(String indexedValue) {
		return indexedValue == null ? null : Enum.valueOf( enumType, indexedValue );
	}

}