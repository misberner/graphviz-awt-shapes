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

import java.awt.Polygon;

public class Octagon extends Polygon {
	
	private static int[] xpoints(int width) {
		int halfwneg = -(width / 2);
		int halfw2 = width + halfwneg;
		
		int sep = (int)(width * 0.3);
		
		return new int[]{halfwneg, halfwneg, halfwneg + sep, halfw2 - sep, halfw2, halfw2, halfw2 - sep, halfwneg + sep};
	}
	
	private static int[] ypoints(int height) {
		int halfhneg = -(height / 2);
		int halfh2 = height + halfhneg;
		
		int sep = (int)(height * 0.3);
		
		return new int[]{halfhneg + sep, halfh2 - sep, halfh2, halfh2, halfh2 - sep, halfhneg + sep, halfhneg, halfhneg}; 
	}
	
	private static final long serialVersionUID = 1L;

	public Octagon(int width, int height) {
		super(xpoints(width), ypoints(height), 8);
	}

}
