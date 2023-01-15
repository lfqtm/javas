package com.javas.design.decorator;

public class DecoratorTest {
	public static void main(String[] args) {
		LiuDeHuaDecorator decorator = new LiuDeHuaDecorator(new LiuDeHua());

		decorator.sing();
		decorator.dance();
	}


}

class LiuDeHuaDecorator implements Star {

	private LiuDeHua liuDeHua;

	public LiuDeHuaDecorator(LiuDeHua liuDeHua) {
		this.liuDeHua = liuDeHua;
	}

	@Override
	public void sing() {
		System.out.println("深情的"); //扩展
		liuDeHua.sing();

	}

	@Override
	public void dance() {
		liuDeHua.dance();
	}
}

class LiuDeHua implements Star {

	@Override
	public void sing() {
		System.out.println("唱给我一杯忘情水~");
	}

	@Override
	public void dance() {
		System.out.println("跳老年迪斯科~");
	}
}


interface Star {
	void sing();
	void dance();
}
