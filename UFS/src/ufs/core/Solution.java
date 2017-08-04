package ufs.core;

import java.lang.Math;

public class Solution implements Cloneable {

	private double[] arraySolution;
	private double objetivo;
	private double max;
	private double min;
	
	//Inclusão temporária
    private int lastPosition;
	private int changedPosition;
    private double changedValue;       
    

	public Solution(int dimensaoArray, double max, double min) {
		inicializaArray(dimensaoArray, max, min);
		
	}

	public double[] inicializaArray(int dimensaoArray, double max, double min) {
		// gera array
		this.arraySolution = new double[dimensaoArray];
		for (int i = 0; i < arraySolution.length; i++) {

			int nunBin = (int) (Math.random() * 2);

			if (nunBin == 1) {
				this.arraySolution[i] = Math.random() * max;
			} else {
				this.arraySolution[i] = Math.random() * min;
			}
		}
		return arraySolution;
	}

	public double[] getArraySolution() {
		return arraySolution;
	}

	public void setArraySolution(double[] arraySolution) {
		this.arraySolution = arraySolution;
	}

	public double getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(double objetivo) {
		this.objetivo = objetivo;
	}

	@Override
	public Solution clone() throws CloneNotSupportedException {
		Solution clone = (Solution) super.clone();
		clone.arraySolution = this.arraySolution.clone();
		clone.objetivo = this.objetivo;
		clone.max = this.max;
		clone.min = this.min;
		//clone.setChangedPosition(this.changedPosition);
		//clone.setChangedValue(this.changedValue);
		//clone.setLastPosition(this.lastPosition);
		
		return clone;
	}

	public void imprimeVetor(double[] vetor) {

		for (int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i]);
		}

	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public int getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(int lastPosition) {
		this.lastPosition = lastPosition;
	}

	public int getChangedPosition() {
		return changedPosition;
	}

	public void setChangedPosition(int changedPosition) {
		this.changedPosition = changedPosition;
	}

	public double getChangedValue() {
		return changedValue;
	}

	public void setChangedValue(double changedValue) {
		this.changedValue = changedValue;
	}
}
