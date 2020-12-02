package id.ac.its.izzulhaq023;

import javax.swing.JOptionPane;

public class MainApp {

	public static void main(String[] args) {
		Object shapeType = JOptionPane.showInputDialog(null, "Pilih Shape", "Shape", JOptionPane.QUESTION_MESSAGE, null, new String[] {"Pilih Shape", "Circle", "Triangle", "Rectangle", "Square"}, "Pilih Shape");
		
		if(shapeType == "Circle") {
			String inputRadius = JOptionPane.showInputDialog("Masukkan Radius!");
			
			Circle circle = new Circle(Double.parseDouble(inputRadius));
			
			JOptionPane.showMessageDialog(null, String.format("Luas dan Keliling Lingkaran dengan Radius %.2f adalah %.2f dan %.2f", circle.getRadius(), circle.getArea(), circle.getCircumference()), "Luas dan Keliling", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(shapeType == "Triangle") {
			String aSide = JOptionPane.showInputDialog("Masukkan sisi A!");
			String bSide = JOptionPane.showInputDialog("Masukkan sisi B!");
			String cSide = JOptionPane.showInputDialog("Masukkan sisi C!");
			
			double a = Double.parseDouble(aSide);
			double b = Double.parseDouble(bSide);
			double c = Double.parseDouble(cSide);
			//double d;
			
			if((a <= b && b <= c) || (b <= a) && (a <= c)) {
				if((a + b) <= c) {
					JOptionPane.showMessageDialog(null, "Segitiga Tidak Valid", "Validasi Segitiga", JOptionPane.WARNING_MESSAGE);
				}
				else {
					Triangle triangle = new Triangle(a, b, c);
					
					JOptionPane.showMessageDialog(null, String.format("Luas dan Keliling Segitiga dengan sisi %.2f, %.2f, dan %.2f adalah %.2f dan %.2f", triangle.getA(), triangle.getB(), triangle.getC(), triangle.getArea(), triangle.getCircumference()), "Luas dan Keliling", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if((a <= c && c <= b) || (c <= a && a <= b)) {
				if((a + c) <= b) {
					JOptionPane.showMessageDialog(null, "Segitiga Tidak Valid", "Validasi Segitiga", JOptionPane.WARNING_MESSAGE);
				}
				else {
					Triangle triangle = new Triangle(a, b, c);
					
					JOptionPane.showMessageDialog(null, String.format("Luas dan Keliling Segitiga dengan sisi %.2f, %.2f, dan %.2f adalah %.2f dan %.2f", triangle.getA(), triangle.getB(), triangle.getC(), triangle.getArea(), triangle.getCircumference()), "Luas dan Keliling", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if((b <= c && c <= a)) {
				if((b + c) <= a) {
					JOptionPane.showMessageDialog(null, "Segitiga Tidak Valid", "Validasi Segitiga", JOptionPane.WARNING_MESSAGE);
				}
				else {
					Triangle triangle = new Triangle(a, b, c);
					
					JOptionPane.showMessageDialog(null, String.format("Luas dan Keliling Segitiga dengan sisi %.2f, %.2f, dan %.2f adalah %.2f dan %.2f", triangle.getA(), triangle.getB(), triangle.getC(), triangle.getArea(), triangle.getCircumference()), "Luas dan Keliling", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		else if(shapeType == "Rectangle") {
			String inputHeight = JOptionPane.showInputDialog("Masukkan Lebar!");
			String inputWidth = JOptionPane.showInputDialog("Masukkan Panjang!");
			
			Rectangle rectangle = new Rectangle(Double.parseDouble(inputHeight), Double.parseDouble(inputWidth));
			
			JOptionPane.showMessageDialog(null, String.format("Luas dan Keliling Persegi Panjang dengan Panjang %.2f dan Lebar %.2f adalah %.2f dan %.2f", rectangle.getWidth(), rectangle.getHeight(), rectangle.getArea(), rectangle.getCircumference()), "Luas dan Keliling", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(shapeType == "Square") {
			String inputSide = JOptionPane.showInputDialog("Masukkan Sisi!");
			
			Square square = new Square(Double.parseDouble(inputSide));
			
			JOptionPane.showMessageDialog(null, String.format("Luas dan Keliling Persegi dengan Sisi %.2f dan adalah %.2f dan %.2f", square.getHeight(), square.getArea(), square.getCircumference()), "Luas dan Keliling", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
