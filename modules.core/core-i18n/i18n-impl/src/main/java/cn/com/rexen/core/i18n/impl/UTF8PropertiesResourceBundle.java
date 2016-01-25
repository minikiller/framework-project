/*
 * Copyright 2009 OW2 Chameleon
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.com.rexen.core.i18n.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * UTF-8 {@link ResourceBundle} implementation. This implementation overrides
 * the {@link ResourceBundle#handleGetObject(String)} method
 * on a wrapped {@link PropertyResourceBundle} to support UTF-8.
 */
public class UTF8PropertiesResourceBundle extends ResourceBundle {

	/**
	 * The wrapped property resource bundle.
	 */
	private PropertyResourceBundle m_bundle;

	/**
	 * Creates a UTF8PropertiesResourceBundle
	 *
	 * @param bundle
	 *            the wrapped property resource bundle.
	 */
	public UTF8PropertiesResourceBundle(PropertyResourceBundle bundle) {
		m_bundle = bundle;
	}

	/**
	 * Creates a UTF8PropertiesResourceBundle
	 *
	 * @param is
	 *            an input stream to create the {@link PropertyResourceBundle}.
	 * @throws IOException
	 *             if the input stream cannot be read, or if the
	 *             {@link PropertyResourceBundle} cannot be created correctly.
	 */
	public UTF8PropertiesResourceBundle(InputStream is) throws IOException {
		m_bundle = new PropertyResourceBundle(is);
	}

	/**
	 * Gets the keys contained in the wrapped {@link PropertyResourceBundle}.
	 *
	 * @return the list of key.
	 * @see ResourceBundle#getKeys()
	 */
	public Enumeration<String> getKeys() {
		return m_bundle.getKeys();
	}

	/**
	 * This methods reads the value associated with the given key from the
	 * wrapped {@link PropertyResourceBundle} using ISO-8859-1, and returned a
	 * UTF-8 string.
	 *
	 * @param key
	 *            the key
	 * @return the UTF-8 encoded localized value.
	 * @see ResourceBundle#handleGetObject(String)
	 */
	protected Object handleGetObject(String key) {
		String value = (String) m_bundle.handleGetObject(key);
		try {
			return new String(value.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// Shouldn't fail - but should we still add logging message?
			return null;
		}
	}
}
