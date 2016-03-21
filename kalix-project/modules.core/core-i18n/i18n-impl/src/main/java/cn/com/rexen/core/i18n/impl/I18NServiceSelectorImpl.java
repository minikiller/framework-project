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
import cn.com.rexen.core.i18n.api.I18nServiceSelector;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.Requires;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * {@link I18nServiceSelector} implementation.
 * This implementation support locale delegation to parent locales.
 * Returned set of {@link I18nService} are not necessary instance of
 * {@link I18nServiceImpl}.
 */
@Component
@Provides
public class I18NServiceSelectorImpl implements I18nServiceSelector {

	/**
	 * The list of available {@link I18nService}.
	 */
	@Requires(optional = true)
	private I18nService[] m_i18n;

	/**
	 * Creates a {@link I18NServiceSelectorImpl}.
	 */
	public I18NServiceSelectorImpl() { }

	/**
	 * Creates a {@link I18NServiceSelectorImpl}. This constructor is for
	 * testing purpose only.
	 *
	 * @param services
	 *            the available services.
	 */
	protected I18NServiceSelectorImpl(I18nService[] services) {
		this();
		m_i18n = services;
	}

	/**
	 * Gets all {@link I18nService} providers localizing the given resource
	 * name.
	 *
	 * @param resourceName
	 *            the resource name
	 * @return the array of {@link I18nService}
	 * @see I18nServiceSelector#getI18nServices(String)
	 */
	public I18nService[] getI18nServices(String resourceName) {
		return findServicesForResource(m_i18n, resourceName);
	}

	/**
	 * Gets all {@link I18nService} providers localizing the given resource name
	 * and supporting the current locale. This methods applies a strict locale
	 * matching.
	 *
	 * @param resourceName
	 *            the resource name
	 * @return the array of {@link I18nService}
	 * @see I18nServiceSelector#getI18nServicesForCurrentLocale(String)
	 */
	public I18nService[] getI18nServicesForCurrentLocale(String resourceName) {
		return getI18nServicesForCurrentLocale(resourceName, false);
	}

	/**
	 * Gets all the i18n services from services having the given locale. The
	 * resulting list may includes parent locale, if includeParents is set to
	 * true.
	 *
	 * @param services
	 *            the list of services.
	 * @param locale
	 *            the locale
	 * @param includeParents
	 *            enables parent inclusion
	 * @return the resulting sets of i18n services matching the request. An
	 *         empty array is returned when the request doesn't have any
	 *         matching services.The returned list is necessary a subset of
	 *         services.
	 */
	private I18nService[] findServicesForLocale(I18nService[] services,
			Locale locale, boolean includeParents) {
		List<I18nService> list = new ArrayList<I18nService>();

		List<Locale> locales = getCandidateLocales(locale);
		// Full match added first.
		for (I18nService svc : services) {
			if (svc.getLocale().equals(locales.get(0))) {
				list.add(svc);
			}
		}

		if (!includeParents) {
			// We stop the research here
			return (I18nService[]) list.toArray(new I18nService[list.size()]);
		}
		// Else we continue

		// No variant match
		for (I18nService svc : services) {
			if (locales.size() >= 2 && svc.getLocale().equals(locales.get(1))) {
				if (!list.contains(svc)) {
					list.add(svc);
				}
			}
		}

		// No variant and no country match
		for (I18nService svc : services) {
			if (locales.size() >= 3 && svc.getLocale().equals(locales.get(2))) {
				if (!list.contains(svc)) {
					list.add(svc);
				}
			}
		}

		return (I18nService[]) list.toArray(new I18nService[list.size()]);
	}

	/**
	 * Gets all the i18n services from services localizing the given resource
	 * name.
	 *
	 * @param services
	 *            the list of service
	 * @param resourceName
	 *            the resource name
	 * @return the resulting sets of i18n services matching the request. An
	 *         empty array is returned when the request doesn't have any
	 *         matching services.The returned list is necessary a subset of
	 *         services.
	 */
	private I18nService[] findServicesForResource(I18nService[] services,
			String resourceName) {
		List<I18nService> list = new ArrayList<I18nService>();
		for (I18nService svc : services) {
			String[] resources = svc.getResources();
			if (resources != null) {
				for (String res : resources) {
					if (resourceName.equals(res) && !list.contains(svc)) {
						list.add(svc);
					}
				}
			}
		}
		return (I18nService[]) list.toArray(new I18nService[list.size()]);

	}

	/**
	 * Returns a <code>List</code> of <code>Locale</code>s as candidate locales
	 * for <code>locale</code>.
	 * <p>
	 * The implementation returns a <code>List</code> containing
	 * <code>Locale</code>s in the following sequence:
	 *
	 * <pre>
	 *     Locale(language, country, variant)
	 *     Locale(language, country)
	 *     Locale(language)
	 * </pre>
	 *
	 * where <code>language</code>, <code>country</code> and
	 * <code>variant</code> are the language, country and variant values of the
	 * given <code>locale</code>, respectively. Locales where the final
	 * component values are empty strings are omitted.
	 *
	 * @param locale
	 *            the locale for which a resource bundle is desired
	 * @return a <code>List</code> of candidate <code>Locale</code>s for the
	 *         given <code>locale</code>
	 */
	public List<Locale> getCandidateLocales(Locale locale) {

		String language = locale.getLanguage();
		String country = locale.getCountry();
		String variant = locale.getVariant();

		List<Locale> locales = new ArrayList<Locale>(3);
		if (variant.length() > 0) {
			locales.add(locale);
		}
		if (country.length() > 0) {
			locales.add((locales.size() == 0) ? locale : new Locale(language,
					country, ""));
		}
		if (language.length() > 0) {
			locales.add((locales.size() == 0) ? locale : new Locale(language,
					"", ""));
		}
		return locales;
	}

	/**
	 * Gets all {@link I18nService} providers localizing the given resource name
	 * and supporting the current locale. According to
	 * <code>includeParents</include>, the result
	 * will contain also service supporting parent locales.
	 *
	 * @param resourceName
	 *            the resource name
	 * @param includeParents
	 *            does the result set of services must include parent locale or
	 *            not.
	 * @return the array of {@link I18nService}
	 * @see I18nServiceSelector#getI18nServicesForCurrentLocale(String,
	 *      boolean)
	 */
	public I18nService[] getI18nServicesForCurrentLocale(String resourceName,
			boolean includeParents) {
		return getI18nServices(resourceName, Locale.getDefault(),
				includeParents);
	}

	/**
	 * Gets all {@link I18nService} providers localizing the given resource name
	 * and supporting the given locale. This methods applies a strict locale
	 * matching.
	 *
	 * @param resourceName
	 *            the resource name
	 * @param locale
	 *            the locale
	 * @return the array of {@link I18nService}
	 * @see I18nServiceSelector#getI18nServices(String,
	 *      Locale)
	 */
	public I18nService[] getI18nServices(String resourceName, Locale locale) {
		return getI18nServices(resourceName, locale, false);
	}

	/**
	 * Gets all {@link I18nService} providers localizing the given resource name
	 * and supporting the given locale. According to
	 * <code>includeParents</include>, the result
	 * will contain also service supporting parent locales.
	 *
	 * @param resourceName
	 *            the resource name
	 * @param locale
	 *            the locale
	 * @param includeParents
	 *            does the result set of services must include parent locale or
	 *            not
	 * @return the array of {@link I18nService}
	 * @see I18nServiceSelector#getI18nServices(String,
	 *      Locale, boolean)
	 */
	public I18nService[] getI18nServices(String resourceName, Locale locale,
			boolean includeParents) {
		I18nService[] services = findServicesForResource(m_i18n, resourceName);
		services = findServicesForLocale(services, locale, includeParents);
		return services;
	}

	/**
	 * Gets all {@link I18nService} providers supporting the given locale. This
	 * methods applies a strict locale matching.
	 *
	 * @param locale
	 *            the locale
	 * @return the array of {@link I18nService}
	 * @see I18nServiceSelector#getI18nServices(Locale)
	 */
	public I18nService[] getI18nServices(Locale locale) {
		return getI18nServices(locale, false);
	}

	/**
	 * Gets all {@link I18nService} providers supporting the given locale.
	 * According to <code>includeParents</include>, the result
	 * will contain also service supporting parent locales.
	 *
	 * @param locale
	 *            the locale
	 * @param includeParents
	 *            does the result set of services must include parent locale or
	 *            not
	 * @return the array of {@link I18nService}
	 * @see I18nServiceSelector#getI18nServices(Locale,
	 *      boolean)
	 */
	public I18nService[] getI18nServices(Locale locale, boolean includeParents) {
		return findServicesForLocale(m_i18n, locale, includeParents);
	}

	/**
	 * Gets a i18n service localizing the given resource for the current locale.
	 * This methods applies a strict locale matching.
	 *
	 * @param resourceName
	 *            the resource name
	 * @return a matching {@link I18nService} or <code>null</code> if not
	 *         matching service found.
	 * @see I18nServiceSelector#getI18nServiceForCurrentLocale(String)
	 */
	public I18nService getI18nServiceForCurrentLocale(String resourceName) {
		return getI18nService(resourceName, Locale.getDefault(), false);
	}

	/**
	 * Gets a i18n service localizing the given resource for the given locale.
	 * This methods applies a strict locale matching.
	 *
	 * @param resourceName
	 *            the resource name
	 * @param locale
	 *            the locale
	 * @return a matching {@link I18nService} or <code>null</code> if not
	 *         matching service found.
	 * @see I18nServiceSelector#getI18nService(String,
	 *      Locale)
	 */
	public I18nService getI18nService(String resourceName, Locale locale) {
		return getI18nService(resourceName, locale, false);
	}

	/**
	 * Gets a i18n service localizing the given resource for the current locale.
	 * According to includeParents, if no matching service found, this methods
	 * must also looks for parent locales.
	 *
	 * @param resourceName
	 *            the resource name
	 * @param includeParents
	 *            does the returned service can be a parent locale.
	 * @return a matching {@link I18nService} or <code>null</code> if not
	 *         matching service found.
	 * @see I18nServiceSelector#getI18nServiceForCurrentLocale(String,
	 *      boolean)
	 */
	public I18nService getI18nServiceForCurrentLocale(String resourceName,
			boolean includeParents) {
		return getI18nService(resourceName, Locale.getDefault(), includeParents);
	}

	/**
	 * Gets a i18n service localizing the given resource for the given locale.
	 * According to includeParents, if no matching service found, this methods
	 * must also looks for parent locales.
	 *
	 * @param resourceName
	 *            the resource name
	 * @param locale
	 *            the locale
	 * @param includeParents
	 *            does the returned service can be a parent locale.
	 * @return a matching {@link I18nService} or <code>null</code> if not
	 *         matching service found.
	 * @see I18nServiceSelector#getI18nService(String,
	 *      Locale, boolean)
	 */
	public I18nService getI18nService(String resourceName, Locale locale,
			boolean includeParents) {
		I18nService[] services = findServicesForResource(m_i18n, resourceName);
		List<Locale> locales = getCandidateLocales(locale);
		I18nService fullMatch = null;
		I18nService noVariantMatch = null;
		I18nService noVariantnoCountryMatch = null;
		for (I18nService svc : services) {
			if (fullMatch == null && svc.getLocale().toString().equalsIgnoreCase(locales.get(0).toString())) {
				fullMatch = svc;
			}

			if (noVariantMatch == null && locales.size() >= 2
					&& svc.getLocale().toString().equalsIgnoreCase(locales.get(1).toString())) {
				noVariantMatch = svc;
			}

			if (noVariantnoCountryMatch == null && locales.size() >= 3
					&& svc.getLocale().toString().equalsIgnoreCase(locales.get(2).toString())) {
				noVariantnoCountryMatch = svc;
			}
		}

		if (!includeParents || fullMatch != null) {
			return fullMatch;
		} else {
			if (noVariantMatch != null) {
				return noVariantMatch;
			} else {
				return noVariantnoCountryMatch;
			}
		}

	}

}
