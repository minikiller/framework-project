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

import cn.com.rexen.core.i18n.api.I18nService;
import org.apache.felix.ipojo.annotations.*;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Implementation of the i18n service. It reflects one
 * {@link ResourceBundle}.
 * Instances are created using the {@link I18nExtender}.
 * Instance configuration contains:
 * <ul>
 * <li>i18n.locale : the locale</li>
 * <li>i18n.resources : the resources (String array)</li>
 * <li>i18n.url : the url on the resource file</li>
 * <ul>
 * This implementation supports regular resource file (Properties),
 * utf8-properties files (encoded using UTF-8) and XML files XML
 * Properties). Empty files are rejected.
 */
@Component(name="cn.com.rexen.core.i18n.impl")
@Provides
public class I18nServiceImpl implements I18nService {

	/**
	 * The locale property.
	 */
	@ServiceProperty(name= I18nService.LOCALE_PROPERTY, mandatory=true)
	private Locale m_locale;

	/**
	 * The resources.
	 */
	@ServiceProperty(name=I18nService.RESOURCE_PROPERTY)
	private String[] m_resources;

	/**
	 * The URL to the resource file.
	 */
	@Property(name="i18n.url", mandatory=true)
	private URL m_url;

	/**
	 * The loaded resource bundle. Be aware that this
	 * can be a customized implementation such as
	 * {@link UTF8PropertiesResourceBundle} and
	 *  {@link XMLResourceBundle}
	 */
	private ResourceBundle m_bundle;

	/**
	 * Empty constructor used by iPOJO.
	 */
	public I18nServiceImpl() { }

	/**
	 * Constructors used for testing purpose.
	 * @param resources the resources
	 * @param locale the locale
	 * @param url the url
	 * @throws IOException if the URL cannot be read or if the
	 * pointed file is empty.
	 */
	I18nServiceImpl(String[] resources, Locale locale, URL url) throws IOException {
		this();
		m_resources = resources;
		m_locale = locale;
		m_url = url;

		start();
	}

	/**
	 * Starts the service.
	 * This method just reads the resource bundle.
	 * @throws IOException if the URL cannot be read or if the pointed file
	 * is empty.
	 */
	@Validate
	public void start() throws IOException {
		if (m_url.toExternalForm().endsWith(".xml")) {
			// XML Format
			m_bundle = new XMLResourceBundle(m_url.openStream());
		} else if (m_url.toExternalForm().endsWith(".utf8-properties")) {
			// UTF-8 Properties file
			m_bundle = new UTF8PropertiesResourceBundle(m_url.openStream());
		} else {
			// Properties file
			m_bundle = new PropertyResourceBundle(m_url.openStream());
		}

		if (m_bundle == null) {
			throw new IOException(m_url.toExternalForm() + " is not a valid resource - cannot load the file");
		}

		if (m_bundle.keySet().isEmpty()) {
			throw new IOException(m_url.toExternalForm() + " is not a valid resource - no keys");
		}

	}

	/**
	 * Gets the localized message for the given key.
	 * @param key the key
	 * @return the localized message or <code>null</code> if the key does not
	 * exist in the bundle.
	 * @see cn.com.rexen.core.i18n.api.I18nService#getString(String)
	 */
	public String getString(String key) {
		return m_bundle.getString(key);
	}

	/**
	 * Gets the keys contained in the bundle.
	 * @return the keys. At least one key is returned as empty bundle
	 * was rejected.
	 * @see cn.com.rexen.core.i18n.api.I18nService#getKeys()
	 */
	public String[] getKeys() {
		List<String> list = new ArrayList<String>();
		Enumeration<String> keys = m_bundle.getKeys();
		while (keys.hasMoreElements()) {
			list.add(keys.nextElement());
		}
		return (String[]) list.toArray(new String[list.size()]);
	}

	/**
	 * Gets the localized resources.
	 * @return the localized resources, or an empty array if
	 * no resources were specified.
	 * @see cn.com.rexen.core.i18n.api.I18nService#getResources()
	 */
	public String[] getResources() {
		if (m_resources == null) {
			return new String[0];
		} else {
			return m_resources;
		}
	}

	/**
	 * Gets the locale.
	 * @return the locale
	 * @see cn.com.rexen.core.i18n.api.I18nService#getLocale()
	 */
	public Locale getLocale() {
		return m_locale;
	}

}
