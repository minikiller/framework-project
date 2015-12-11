/**
 * Licensed to the Austrian Association for Software Tool Integration (AASTI)
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. The AASTI licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.com.rexen.core.delegate;

public final class Constants {

    /**
     * attribute name used in manifest-headers for declaring which classes should be provided using a
     * "ClassProvider"-service
     */
    public static final String PROVIDED_CLASSES_HEADER = "Provided-Classes";
    public static final String PROVIDED_CLASSES_KEY = "providedClasses";
    public static final String DELEGATION_CONTEXT_KEY = "delegationContext";
    public static final String DELEGATION_ANNOTATIONS_HEADER = "Delegation-Annotations";
    public static final String CLASS_VERSION_KEY = "classVersion";
    public static final String PROVIDED_RESOURCES_HEADER = "Provided-Resources";
    public static final String PROVIDED_RESOURCES_KEY = "providedResources";

    private Constants() {
    }
}
