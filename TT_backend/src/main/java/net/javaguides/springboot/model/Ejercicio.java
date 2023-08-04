//Modelo de la tabla de ejercicios
package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ejercicio")
public class Ejercicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_ejercicio;
	
	@Column(name="X1")
	private double X1;
	
	@Column(name="Sign1")
	private char Sign1;
	
	@Column(name="Y1")
	private double Y1;
	
	@Column(name="Const1")
	private double Const1;
	
	@Column(name="X2")
	private double X2;
	
	@Column(name="Sign2")
	private char Sign2;
	
	@Column(name="Y2")
	private double Y2;
	
	@Column(name="Const2")
	private double Const2;
	
	@Column(name="AnswerX")
	private double AnswerX;
	
	@Column(name="AnswerY")
	private double AnswerY;
	
	public Ejercicio() {
		
	}
	
	public Ejercicio(double x1, char sign1, double y1, double const1, double x2, char sign2, double y2, double const2,
			double answerX, double answerY) {
		super();
		X1 = x1;
		Sign1 = sign1;
		Y1 = y1;
		Const1 = const1;
		X2 = x2;
		Sign2 = sign2;
		Y2 = y2;
		Const2 = const2;
		AnswerX = answerX;
		AnswerY = answerY;
	}
	public int getId_ejercicio() {
		return id_ejercicio;
	}
	public void setId_ejercicio(int id_ejercicio) {
		this.id_ejercicio = id_ejercicio;
	}
	public double getX1() {
		return X1;
	}
	public void setX1(double x1) {
		X1 = x1;
	}
	public char getSign1() {
		return Sign1;
	}
	public void setSign1(char sign1) {
		Sign1 = sign1;
	}
	public double getY1() {
		return Y1;
	}
	public void setY1(double y1) {
		Y1 = y1;
	}
	public double getConst1() {
		return Const1;
	}
	public void setConst1(double const1) {
		Const1 = const1;
	}
	public double getX2() {
		return X2;
	}
	public void setX2(double x2) {
		X2 = x2;
	}
	public char getSign2() {
		return Sign2;
	}
	public void setSign2(char sign2) {
		Sign2 = sign2;
	}
	public double getY2() {
		return Y2;
	}
	public void setY2(double y2) {
		Y2 = y2;
	}
	public double getConst2() {
		return Const2;
	}
	public void setConst2(double const2) {
		Const2 = const2;
	}
	public double getAnswerX() {
		return AnswerX;
	}
	public void setAnswerX(double answerX) {
		AnswerX = answerX;
	}
	public double getAnswerY() {
		return AnswerY;
	}
	public void setAnswerY(double answerY) {
		AnswerY = answerY;
	}
	
}
