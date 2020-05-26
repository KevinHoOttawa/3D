package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import stl.Solid;
import stl.Vertex;

class SolidTest {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	void testInvalid() {
		Solid g = new Solid();
		Solid d = new Solid();
		
		Vertex v1 = new Vertex(0,0,0);
		Vertex v2 = new Vertex(0,0,1);
		
		Vertex[] a = new Vertex[] {};
		Vertex[] b = new Vertex[] {v1};
		Vertex[] c = new Vertex[] {v1, v2};
		
		assertEquals(false, g.addFacet(a));
		assertEquals(false, g.addFacet(b));
		assertEquals(false, g.addFacet(c));
		
		g.addFacet();
		
		assertEquals(d.toString(), g.toString());
	}
	
	@Test
	void test3() {
		Vertex v1 = new Vertex(0,0,0);
		Vertex v2 = new Vertex(0,1,0);
		Vertex v3 = new Vertex(0,0,1);
		
		Solid g = new Solid();
		Solid d = new Solid();
		
		Vertex[] a = new Vertex[] {v1, v2, v3};
		
		d.addFacet(a);
		g.addFacet(v1, v2, v3);
		
		assertEquals(true, g.addFacet(a));
		assertEquals(d.toString(), g.toString());
	}
	
	@Test
	void test4() {
		Vertex v1 = new Vertex(0,0,0);
		Vertex v2 = new Vertex(0,1,0);
		Vertex v3 = new Vertex(0,0,1);
		Vertex v4 = new Vertex(1,0,0);
		
		Vertex[] a = new Vertex[] {v1, v2, v3, v4};
		
		Solid g = new Solid();
		Solid d = new Solid();
		
		assertEquals(true, g.addFacet(a));
		
		d.addFacet(a);
		g.addFacet(v1, v2, v3, v4);
		
		assertEquals(d.toString(), g.toString());
	}
	
	@Test
	void test9() {
		Vertex v1 = new Vertex(0,0,0);
		Vertex v2 = new Vertex(0,1,0);
		Vertex v3 = new Vertex(0,0,1);
		Vertex v4 = new Vertex(1,0,0);
		Vertex v5 = new Vertex(1,0,0);
		Vertex v6 = new Vertex(1,0,0);
		Vertex v7 = new Vertex(1,0,0);
		Vertex v8 = new Vertex(1,0,0);
		Vertex v9 = new Vertex(1,0,0);
		
		Vertex[] a = new Vertex[] {v1, v2, v3, v4, v5, v6, v7, v8, v9};
		
		Solid g = new Solid();
		Solid d = new Solid();
		
		assertEquals(true, g.addFacet(a));
		
		d.addFacet(a);
		g.addFacet(v1, v2, v3, v4, v5, v6, v7, v8, v9);
		
		assertEquals(d.toString(), g.toString());
	}
}
