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
package com.github.misberner.graphvizawtshapes.shapes;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.List;


public class MultiShape implements Shape {
	
	private final Shape outermost;
	private final List<Shape> allShapes;

	public MultiShape(Shape ...shapes) {
		this.allShapes = Arrays.asList(shapes);
		this.outermost = shapes[0];
	}

	@Override
	public Rectangle getBounds() {
		return outermost.getBounds();
	}

	@Override
	public Rectangle2D getBounds2D() {
		return outermost.getBounds2D();
	}

	@Override
	public boolean contains(double x, double y) {
		return outermost.contains(x, y);
	}

	@Override
	public boolean contains(Point2D p) {
		return outermost.contains(p);
	}

	@Override
	public boolean intersects(double x, double y, double w, double h) {
		return outermost.intersects(x, y, w, h);
	}

	@Override
	public boolean intersects(Rectangle2D r) {
		return outermost.intersects(r);
	}

	@Override
	public boolean contains(double x, double y, double w, double h) {
		return outermost.contains(x, y, w, h);
	}

	@Override
	public boolean contains(Rectangle2D r) {
		return outermost.contains(r);
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at) {
		return ShapeUtil.concatPathIterators(allShapes, at);
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at, double flatness) {
		return ShapeUtil.concatPathIterators(allShapes, at, flatness);
	}


}
