package com.taxiapp.controllers;

public class CalculationController {
	
	public double estimateCost(double zeroTaxiSharers, double oneTaxiSharers, double twoTaxiSharers, double threeTaxiSharers, double fourTaxiSharers) {
		
		return 5 + (((zeroTaxiSharers*1000)/72.1)*0.13) + ((((oneTaxiSharers*1000)/72.1)*0.13)/2) + ((((twoTaxiSharers*1000)/72.1)*0.13)/3) + 
				((((threeTaxiSharers*1000)/72.1)*0.13)/4) + ((((fourTaxiSharers*1000)/72.1)*0.13)/5);
	}
}
