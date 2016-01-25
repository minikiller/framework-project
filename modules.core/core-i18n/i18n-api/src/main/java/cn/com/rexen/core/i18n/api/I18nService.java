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
 * Internationalization service. Each provider provides message for
 * a specific locale.
 * Providers must expose the <code>i18n.locale</code> property.
 * Providers may also expose the <code>i18.resources</code> property,
 * indicating the localize resources. The semantic of this property
 * is application-specific.
 * Implementations should support propagation to enable the attachment
 * of application-specific properties.
 *
 * @version 1.0.0
 */
public interface I18nService {

    /**
     * Service Properties exposed by provider indicating the
     * locale of the messages. The property value must be a
     * {@link Locale}
     */
    public static final String LOCALE_PROPERTY = "i18n.locale";

    /**
     * Service Properties exposed by provider indicating the
     * localized resources. The property is optional, and the
     * semantic is application-specific. The property value
     * must be an array of {@link String}. If only one resource
     * if localized, the array contains only one entry. If the
     * provider does not specify the localized resources, this
     * property must not be published.
     */
    public static final String RESOURCE_PROPERTY = "i18n.resources";

    public static final String RESOURCE_URL = "i18n.url";

    /**
     * Gets the localized message for the given key.
     *
     * @param key the key
     * @return the localized message, or <code>null</code>
     * if the provider does not have a value for the key.
     */
    String getString(String key);

    /**
     * Gets the list of the localized messages.
     *
     * @return the set of supported keys
     */
    String[] getKeys();

    /**
     * Gets the list of the localized resource.
     * This method returns the value of {@link #RESOURCE_PROPERTY}
     * if exposed. Otherwise, it returns an empty array.
     *
     * @return the set of localized resources, or
     * an empty array if the provider does not
     * specify the localized resources.
     */
    String[] getResources();

    /**
     * Gets the locale offered by the provider.
     * This method returns the value of {@link #LOCALE_PROPERTY}
     *
     * @return the locale
     */
    Locale getLocale();
}
