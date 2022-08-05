package com.dev.oops;

public class Trigger {

	public static void main(String[] args) {
		Kid kid = new Kid();
		kid.talk();
		Man man = new Man();
		man.talk();
		Woman woman = new Woman();
		woman.talk();
		Human human = new Human();
		human.setAge(1);
		human.setName("dfev");
		System.out.println(human.getAge());
		System.out.println(human.getName());
	}
}
