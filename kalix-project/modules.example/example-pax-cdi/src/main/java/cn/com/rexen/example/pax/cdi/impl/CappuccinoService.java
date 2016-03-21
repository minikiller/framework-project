/*
 * Copyright 2014 Harald Wellmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.com.rexen.example.pax.cdi.impl;

import cn.com.rexen.example.pax.cdi.IceCreamService;
//import org.ops4j.pax.cdi.api.BundleScoped;
//import org.ops4j.pax.cdi.api.OsgiServiceProvider;

//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;

//@BundleScoped
//@Singleton
//@OsgiServiceProvider(classes = {IceCreamService.class})
//@Properties(@Property(name = "flavour", value = "cappuccino"))
public class CappuccinoService implements IceCreamService {


    public CappuccinoService() {
        System.out.println("constructing CappuccinoService");
    }

//    @PostConstruct
    public void init() {
        System.out.println("CappuccinoService @PostConstruct");
    }

//    @PreDestroy
    public void destroy() {
        System.out.println("CappuccinoService @PreDestroy");
    }

    @Override
    public String getFlavour() {
        return "Cappuccino";
    }
}
