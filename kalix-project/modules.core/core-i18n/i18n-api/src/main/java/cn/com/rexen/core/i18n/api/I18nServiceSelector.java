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
package cn.com.rexen.core.i18n.api;

import java.util.Locale;

/**
 * Internationalization service selector. This service allows to simplify the
 * selection of the correct {@link I18nService}, when several are exposed.
 * It can also select the {@link I18nService} by using a regression algorithm
 * on the locale.
 * @version 1.0.0
 */
public interface I18nServiceSelector {

	/**
	 * Gets all {@link I18nService} providers localizing the
	 * given resource name.
	 * @param resourceName the resource name
	 * @return the array of {@link I18nService}
	 */
	public I18nService[] getI18nServices(String resourceName);

	/**
	 * Gets all {@link I18nService} providers localizing the
	 * given resource name and supporting the current locale.
	 * This methods applies a strict locale matching.
	 * @param resourceName the resource name
	 * @return the array of {@link I18nService}
	 */
	public I18nService[] getI18nServicesForCurrentLocale(String resourceName);

	/**
	 * Gets all {@link I18nService} providers localizing the
	 * given resource name and supporting the current locale.
	 * According to <code>includeParents</include>, the result
	 * will contain also service supporting parent locales.
	 * @param resourceName the resource name
	 * @param includeParents does the result set of services must include
	 * parent locale or not.
	 * @return the array of {@link I18nService}
	 */
	public I18nService[] getI18nServicesForCurrentLocale(String resourceName, boolean includeParents);

	/**
	 * Gets all {@link I18nService} providers localizing the
	 * given resource name and supporting the given locale.
	 * This methods applies a strict locale matching.
	 * @param resourceName the resource name
	 * @param locale the locale
	 * @return the array of {@link I18nService}
	 */
	public I18nService[] getI18nServices(String resourceName, Locale locale);

	/**
	 * Gets all {@link I18nService} providers localizing the
	 * given resource name and supporting the given locale.
	 * According to <code>includeParents</include>, the result
	 * will contain also service supporting parent locales.
	 * @param resourceName the resource name
	 * @param locale the locale
	 * @param includeParents does the result set of services must include
	 * parent locale or not
	 * @return the array of {@link I18nService}
	 */
	public I18nService[] getI18nServices(String resourceName, Locale locale, boolean includeParents);

	/**
	 * Gets all {@link I18nService} providers supporting the given locale.
	 * This methods applies a strict locale matching.
	 * @param locale the locale
	 * @return the array of {@link I18nService}
	 */
	public I18nService[] getI18nServices(Locale locale);

	/**
	 * Gets all {@link I18nService} providers supporting the given locale.
	 * According to <code>includeParents</include>, the result
	 * will contain also service supporting parent locales.
	 * @param locale the locale
	 * @param includeParents does the result set of services must include
	 * parent locale or not
	 * @return the array of {@link I18nService}
	 */
	public I18nService[] getI18nServices(Locale locale, boolean includeParents);

	/**
	 * Gets a i18n service localizing the given resource for the current locale.
	 * This methods applies a strict locale matching.
	 * @param resourceName the resource name
	 * @return a matching {@link I18nService} or <code>null</code> if not matching
	 * service found.
	 */
	public I18nService getI18nServiceForCurrentLocale(String resourceName);

	/**
	 * Gets a i18n service localizing the given resource for the given locale.
	 * This methods applies a strict locale matching.
	 * @param resourceName the resource name
	 * @param locale the locale
	 * @return a matching {@link I18nService} or <code>null</code> if not matching
	 * service found.
	 */
	public I18nService getI18nService(String resourceName, Locale locale);

	/**
	 * Gets a i18n service localizing the given resource for the current locale.
	 * According to includeParents, if no matching service found, this methods must
	 * also looks for parent locales.
	 * @param resourceName the resource name
	 * @param includeParents does the returned service can be a parent locale.
	 * @return a matching {@link I18nService} or <code>null</code> if not matching
	 * service found.
	 */
	public I18nService getI18nServiceForCurrentLocale(String resourceName, boolean includeParents);

	/**
	 * Gets a i18n service localizing the given resource for the given locale.
	 * According to includeParents, if no matching service found, this methods must
	 * also looks for parent locales.
	 * @param resourceName the resource name
	 * @param locale the locale
	 * @param includeParents does the returned service can be a parent locale.
	 * @return a matching {@link I18nService} or <code>null</code> if not matching
	 * service found.
	 */
	public I18nService getI18nService(String resourceName, Locale locale, boolean includeParents);

}
