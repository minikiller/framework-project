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
import org.apache.felix.ipojo.ComponentInstance;
import org.apache.felix.ipojo.Factory;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Requires;
import org.apache.log4j.Logger;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;

import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;



/**
 * I18N extender. This component analyze others bundles
 * and check the content of the <code>/i18n</code> directory.
 * For all files contained in this directory and sub-directories,
 * it creates an instance of {@link I18nServiceImpl}.
 * The locale is determined by parsing the text between the first '_'
 * and the last '.'.
 * The localized resource is determined using the file name. If the file
 * is in a sub-directory, a fully qualified resource name is computed:
 * <code>
 * /i18n/myapp_fr.properties => myapp
 * /i18n/org/ow2/i18n/Myapp_en.properties => org.ow2.i18n.MyApp
 * </code>
 */
@Component(immediate=true)
public class I18nExtender implements BundleListener {

	/**
	 * The bundle context.
	 */
	private BundleContext m_context;

	/**
	 * The {@link I18nServiceImpl} factory.
	 */
	@Requires(filter="(factory.name=cn.com.rexen.core.i18n.impl)")
	private Factory m_i18nFactory;

	/**
	 * The managed extensions.
	 */
	private List<I18nExtension> m_extensions = new ArrayList<I18nExtension>();

	/**
	 * The logger.
	 */
	private Logger m_logger = Logger.getLogger(I18nExtender.class.getName());

	/**
	 * Creates the extender.
	 * @param bc the bundle context
	 */
	public I18nExtender(BundleContext bc) {
		m_context = bc;

		m_context.addBundleListener(this);
		for (Bundle bundle : m_context.getBundles()) {
			analyze(bundle);
		}
	}

	/**
	 * Analyzes the content of the given bundle
	 * @param b the bundle.
	 */
	private synchronized void analyze(Bundle b) {
		m_logger.info("Analyzing " + b.getSymbolicName());
		traverse("/i18n/", "/i18n/", b);
	}

	/**
	 * Traverse the content of the given bundle from the given
	 * path. For all matching file, an extension is created.
	 * This method is recursive.
	 * @param path the path
	 * @param prefix the prefix ('/18n/')
	 * @param bundle the bundle
	 */
	private void traverse(String path, String prefix, Bundle bundle) {
		if (path.endsWith("/")) {
			// Directory
			@SuppressWarnings("unchecked")
			Enumeration<String> paths = bundle.getEntryPaths(path);
			if (paths != null) {
				while (paths.hasMoreElements()) {
					String p = paths.nextElement();
					traverse(p, prefix, bundle);
				}
			}
		} else {
			// File
			String file = path.substring(prefix.length() -1);
			file = file.replace("/", ".");
			int index = file.indexOf('_');
			if (index != -1) {
				String resourceName = null;
				if (file.startsWith("/")) {
					resourceName = file.substring(1, index);
				} else {
					resourceName = file.substring(0, index);
				}

				String locale = file.substring(index + 1);

				// Remove the extension
				if (locale.lastIndexOf('.') != -1) {
					int lastDot = locale.lastIndexOf('.');
					locale = locale.substring(0, lastDot);
				}


				URL url = bundle.getEntry(path);
				if (url != null) {
					createExtension(bundle, resourceName, locale, url);
				} else {
					m_logger.error("Cannot open " + path + " from " + bundle.getSymbolicName());
				}
			} else {
				m_logger.error("Malformed resource file in " + bundle.getBundleId() + " for " + path);
			}
		}
	}

	/**
	 * Creates an extension for the given bundle, resource, locale and url.
	 * This method is syncrhonized to avoid concurrent extension creation.
	 * @param bundle the bundle
	 * @param resourceName the resource name
	 * @param locale the locale
	 * @param url the url
	 */
	private synchronized void createExtension(Bundle bundle, String resourceName,
			String locale, URL url) {
		I18nExtension extension = new I18nExtension(bundle, resourceName, locale);
		if (m_extensions.contains(extension)) {
			return;
		}
		Properties configuration = new Properties();
		configuration.put(I18nService.RESOURCE_PROPERTY, new String[]{resourceName});
		configuration.put(I18nService.LOCALE_PROPERTY, locale);
		configuration.put(I18nService.RESOURCE_URL, url);

		ComponentInstance ci;
		try {
			ci = m_i18nFactory.createComponentInstance(configuration);
			extension.setInstance(ci);
			m_extensions.add(extension);
			m_logger.info("I18N Extension created for " + resourceName + " - " + locale);
		} catch (Exception e) {
			m_logger.error("Cannot create I18N Extension Instance : " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Tracks bundle events.
	 * If a bundle is started, the bundle is analyzed.
	 * If a bundle is stopped, the extensions created for this bundle are destroyed.
	 * This method is synchronized to avoid concurrent calls.
	 * @param event the bundle event
	 * @see BundleListener#bundleChanged(BundleEvent)
	 */
	public synchronized void bundleChanged(BundleEvent event) {
		if (event.getType() == BundleEvent.STARTED) {
			analyze(event.getBundle());
			return;
		}
		if (event.getType() == BundleEvent.UNRESOLVED) {
			List<I18nExtension> toRemove = new ArrayList<I18nExtension>();
			for (I18nExtension extension : m_extensions) {
				if (extension.m_bundle.getBundleId() == event.getBundle().getBundleId()) {
					extension.m_instance.dispose();
					toRemove.add(extension);
					m_logger.info("I18N Removed : " + extension.m_resource + " - " + extension.m_locale);
				}
			}
			m_extensions.removeAll(toRemove);
		}
	}

	/**
	 * i18n extension structure.
	 */
	private class I18nExtension {
		/**
		 * The bundle object.
		 */
		private final Bundle m_bundle;
		/**
		 * The resource.
		 */
		private final String m_resource;
		/**
		 * The locale.
		 */
		private final String m_locale;
		/**
		 * The created instance.
		 */
		private ComponentInstance m_instance;

		/**
		 * Creates an extension.
		 * @param bundle the bundle
		 * @param resource the resource
		 * @param locale the locale
		 */
		public I18nExtension(Bundle bundle, String resource,
				String locale) {
			m_bundle = bundle;
			m_resource = resource;
			m_locale = locale;
		}

		/**
		 * Sets the created instance for this extension.
		 * @param instance the instance
		 */
		public void setInstance(ComponentInstance instance) {
			m_instance = instance;
		}

		/**
		 * Two extensions are equals if and only if the
		 * bundle ids are the same, the resources are equals
		 * and the locales are equals.
		 * @see Object#equals(Object)
		 */
		public boolean equals(Object object) {
			if (object instanceof I18nExtension) {
				I18nExtension extension = (I18nExtension) object;
				return
					m_bundle.getBundleId() == extension.m_bundle.getBundleId()
					&& m_resource.equals(extension.m_resource)
					&& m_locale.equals(extension.m_locale);
			}
			return false;
		}

	}
}
