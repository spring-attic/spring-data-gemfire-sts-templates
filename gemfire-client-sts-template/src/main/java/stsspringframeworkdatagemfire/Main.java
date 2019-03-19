/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package stsspringframeworkdatagemfire;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gemstone.gemfire.cache.Region;

public class Main {
	static Log log = LogFactory.getLog(Main.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("spring.profiles.active","environmentProfileName");
		ApplicationContext context= new ClassPathXmlApplicationContext("META-INF/spring/gemfire/cache-config.xml");
		
		@SuppressWarnings("unchecked")
		Region<Object,Object> region = context.getBean("regionName",Region.class);
		
		log.debug("populating region ...");
		region.put(1,"apple");
		region.put(2,"banana");
		region.put(3,"pear");
		
		log.debug("retreiving region values...");
		
		for (Object obj:region.values()) {
			log.debug(obj);
		}
		
		log.debug("retreiving region keys...");
		for (Object obj:region.keySet()) {
			log.debug(obj+":" + region.get(obj));
		}
	}
}
