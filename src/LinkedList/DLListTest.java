package LinkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DLListTest {

	@Test
	public void testConstructor() {
		DLList<Integer> b= new DLList<Integer>();
		assertEquals("[]", b.toString());
		assertEquals("[]", b.gnirtSot());
		assertEquals(0, b.size());
	}

	@Test
	public void testprepend() {
		DLList<String> ll= new DLList<String>();		
		ll.prepend("a");
		ll.prepend("b");
		ll.prepend("c");
		assertEquals("[c, b, a]", ll.toString());
		assertEquals("[a, b, c]", ll.gnirtSot());
		assertEquals(3, ll.size());
		DLList<String> lll= new DLList<String>();
		lll.prepend("Sampson");
		assertEquals("[Sampson]", lll.toString());
		assertEquals("[Sampson]", lll.gnirtSot());
		assertEquals(1, lll.size());
	}

	@Test
	public void testAppend() {
		DLList<String> ll= new DLList<String>();
		ll.append("a");
		ll.append("b");
		ll.append("c");
		assertEquals("[a, b, c]", ll.toString());
		assertEquals("[c, b, a]", ll.gnirtSot());
		assertEquals(3, ll.size());
	}

	@Test
	public void testgetNode() {
		DLList<String> ll= new DLList<String>();
		ll.append("a");
		ll.append("b");
		ll.append("c");
		ll.append("d");
		ll.append("e");
		ll.append("f");
		ll.append("g");
		assertEquals("a", ll.getNode(0).value());
		assertEquals("b", ll.getNode(1).value());
		assertEquals("c", ll.getNode(2).value());
		assertEquals("d", ll.getNode(3).value());
		assertEquals("e", ll.getNode(4).value());
		assertEquals("f", ll.getNode(5).value());
		assertEquals("g", ll.getNode(6).value());
	}

	@Test
	public void testdelete() {
		DLList<String> ll= new DLList<String>();
		ll.append("a");
		ll.append("b");
		ll.append("c");
		ll.append("d");
		ll.append("e");
		ll.delete(ll.getNode(2));
		assertEquals("[a, b, d, e]", ll.toString());
		assertEquals("[e, d, b, a]", ll.gnirtSot());
		assertEquals(4,ll.size());
		ll.delete(ll.getNode(3));
		assertEquals("[a, b, d]", ll.toString());
		assertEquals("[d, b, a]", ll.gnirtSot());
		assertEquals(3,ll.size());
		ll.delete(ll.getNode(0));
		assertEquals("[b, d]", ll.toString());
		assertEquals("[d, b]", ll.gnirtSot());
		assertEquals(2,ll.size());

	}

	@Test
	public void testinsertAfter() {
		DLList<String> ll= new DLList<String>();
		ll.append("a");
		ll.append("b");
		ll.append("c");
		assertEquals("[a, b, c]",ll.toString());
		ll.insertAfter("d", ll.getNode(2));
		assertEquals(4,ll.size());
		assertEquals("[a, b, c, d]",ll.toString());
		assertEquals("[d, c, b, a]",ll.gnirtSot());
		ll.insertAfter("j", ll.getNode(1));
		assertEquals(5,ll.size());
		assertEquals("[a, b, j, c, d]",ll.toString());
		assertEquals("[d, c, j, b, a]",ll.gnirtSot());

	}
}



