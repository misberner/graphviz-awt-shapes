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
package com.github.misberner.graphvizawtshapes.factories;

import java.awt.Shape;

import com.github.misberner.graphvizawtshapes.ShapeFactory;
import com.github.misberner.graphvizawtshapes.shapes.MultiShape;

public abstract class AbstractTripleShapeFactory extends AbstractShapeFactory {

	private final ShapeFactory baseShapeFactory;
	private final int sizeDec1;
	private final int sizeDec2;
	
	public AbstractTripleShapeFactory(ShapeFactory baseShapeFactory, int sizeDec1, int sizeDec2) {
		this.baseShapeFactory = baseShapeFactory;
		this.sizeDec1 = sizeDec1;
		this.sizeDec2 = sizeDec2;
	}

	@Override
	public Shape createShape(int width, int height) {
		Shape outer = baseShapeFactory.createShape(width, height);
		width -= sizeDec1;
		height -= sizeDec1;
		Shape inner1 = baseShapeFactory.createShape(width, height);
		width -= sizeDec2;
		height -= sizeDec2;
		Shape inner2 = baseShapeFactory.createShape(width, height);
		return new MultiShape(outer, inner1, inner2);
	}


}
