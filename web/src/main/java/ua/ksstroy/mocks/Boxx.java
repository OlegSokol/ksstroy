package ua.ksstroy.mocks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Boxx {

	String name;

	List<Boxx> boxList = new ArrayList<>();

	public Boxx() {
		this.name = "box" ;
		System.out.println("box number " +  " is created");
	}
	public List<Boxx> getBoxList() {
		return boxList;
	}

	public String getName() {
		return name;
	}
	public void recursionFill(int level) {
		if (level > 0) {
			System.out.println(level);
			for (int i = 0; i < 10; i++) {
				this.boxList.add(new Boxx());
			}
			for (Boxx box : this.boxList) {
				box.recursionFill(level - 1);
			}
		}
	}

	public void recursionPrint1() {
		if (this != null)
			for (Boxx box : boxList) {
				System.out.println(box.name);
			}
		for (Boxx box : boxList) {
			box.recursionPrint1();
		}
	}
	public void recursionPrint2() {
		if (this != null)
			for (Boxx box : boxList) {
				System.out.println(box.name);
				box.recursionPrint1();
			}
	}

	public static void main(String[] args) {
		Boxx myBox = new Boxx();
		myBox.recursionFill(3);
//		myBox.recursionPrint1();
		myBox.recursionPrint2();
	}
}
