package spoon.test.position.testclasses;

public class FooLabel {

	void m(boolean x) {
		label1: while(x) {};
		label2: getClass();
		label3: new String();
		label4: x = false;
		label5: /*c1*/ return;
	}
}