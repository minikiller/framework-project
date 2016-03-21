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
import java.util.*;

/**
 * {@link ResourceBundle} implementation for XML files. This class just reads a
 * XML file (Properties), and wraps this {@link Properties} object as a
 * {@link ResourceBundle}.
 */
public class XMLResourceBundle extends ResourceBundle {
	/**
	 * The wrapped properties.
	 */
	private Properties m_props;

	/**
	 * Creates a XMLResourceBundle
	 * @param stream the input stream
	 * @throws IOException if the {@link Properties} cannot be created
	 * correctly.
	 */
	XMLResourceBundle(InputStream stream) throws IOException {
		m_props = new Properties();
		m_props.loadFromXML(stream);
	}

	/**
	 * Gets the localized string for the given key.
	 * @param key the key
	 * @return the localized string
	 * @see ResourceBundle#handleGetObject(String)
	 */
	protected Object handleGetObject(String key) {
		return m_props.getProperty(key);
	}

	/**
	 * Gets the keys from the wrapped properties.
	 * @return the set of key.
	 * @see ResourceBundle#getKeys()
	 */
	public Enumeration<String> getKeys() {
		Set<String> handleKeys = m_props.stringPropertyNames();
		return Collections.enumeration(handleKeys);
	}
}