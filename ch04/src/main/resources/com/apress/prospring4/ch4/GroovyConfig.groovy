package com.apress.prospring4.ch4

import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader
import org.springframework.context.support.GenericApplicationContext

def ctx = new GenericApplicationContext()
def reader = new GroovyBeanDefinitionReader(ctx);

// it's a closure!
reader.beans {
	contact(Contact, firstName: 'Vladimir', lastName: 'Putin', age: 61)
}

ctx.refresh();
println ctx.getBean("contact")

