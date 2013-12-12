/*
 * Copyright (c) 2013, Malte Isberner
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.github.misberner.graphvizawtshapes;

import java.awt.Shape;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class ShapeLibrary {
	
	private static final class Holder {
		static {
			ServiceLoader<ShapeFactory> shapeFactories = ServiceLoader.load(ShapeFactory.class);
			
			Map<String,ShapeFactory> factories = new HashMap<>();
			
			for(ShapeFactory factory : shapeFactories) {
				String[] names = factory.getShapeNames();
				for(String name : names) {
					name = name.toLowerCase();
					if(!factories.containsKey(name)) {
						factories.put(name, factory);
					}
				}
			}
			
			INSTANCE = new ShapeLibrary(factories);
		}
		
		private static final ShapeLibrary INSTANCE;
	}
	
	
	private final Map<String,ShapeFactory> factories;

	private ShapeLibrary(Map<String,ShapeFactory> factories) {
		this.factories = factories;
	}

	
	public static ShapeLibrary getInstance() {
		return Holder.INSTANCE;
	}
	
	
	public Shape createShape(String shapeName) {
		ShapeFactory factory = getShapeFactory(shapeName);
		if(factory == null) {
			return null;
		}
		return factory.createShape();
	}
	
	public Shape createShape(String shapeName, int width, int height) {
		ShapeFactory factory = getShapeFactory(shapeName);
		if(factory == null) {
			return null;
		}
		return factory.createShape(width, height);
	}
	
	private ShapeFactory getShapeFactory(String shapeName) {
		shapeName = shapeName.toLowerCase();
		return factories.get(shapeName);
	}

}
