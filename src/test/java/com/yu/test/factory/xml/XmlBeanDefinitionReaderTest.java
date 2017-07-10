package com.yu.test.factory.xml;

import java.util.Arrays;

import junit.framework.TestCase;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

public class XmlBeanDefinitionReaderTest extends TestCase {

	public void testWithOpenInputStreamAndExplicitValidationMode() {
		SimpleBeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
		System.out.println("registry: " + registry);
		System.out.println(getClass().getResourceAsStream("/test.xml"));
		Resource resource = new InputStreamResource(getClass().getResourceAsStream("/test.xml"));
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
		reader.setValidationMode(XmlBeanDefinitionReader.VALIDATION_DTD);
		reader.loadBeanDefinitions(resource);
		testBeanDefinitions(registry);
	}
	
	private void testBeanDefinitions(BeanDefinitionRegistry registry) {
		assertEquals(24, registry.getBeanDefinitionCount());
		assertEquals(24, registry.getBeanDefinitionNames().length);
		assertTrue(Arrays.asList(registry.getBeanDefinitionNames()).contains("rod"));
		assertTrue(Arrays.asList(registry.getBeanDefinitionNames()).contains("aliased"));
		assertTrue(registry.containsBeanDefinition("rod"));
		assertTrue(registry.containsBeanDefinition("aliased"));
		assertTrue(registry.isAlias("youralias"));
//		String[] aliases = registry.getAliases("aliased");
//		assertEquals(2, aliases.length);
//		assertTrue(ObjectUtils.containsElement(aliases, "myalias"));
//		assertTrue(ObjectUtils.containsElement(aliases, "youralias"));
	}

}
