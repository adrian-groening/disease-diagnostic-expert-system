package com.example.application.views.core;

public class Scoreboard {

	int flu, commonCold, asthma, diabetes, hypertension, hyperthyroidismO, hyperthyroidismUT, migraine, pneumonia, uti;
	int arr[];

	public Scoreboard() {
		flu = 0;
		commonCold = 0;
		asthma = 0;
		diabetes = 0;
		hypertension = 0;

		hyperthyroidismO = 0;
		hyperthyroidismUT = 0;
		migraine = 0;
		pneumonia = 0;
		uti = 0;
	}

	public int getFlu() {
		return flu;
	}

	public int getCC() {
		return commonCold;
	}

	public int getAsthma() {
		return asthma;
	}

	public int getdiabetes() {
		return diabetes;
	}

	public int getHypertension() {
		return hypertension;
	}

	public void plusFlu() {
		flu += 1;
	}

	public void plusCC() {
		commonCold += 1;
	}

	public void plusAsthma() {
		asthma += 1;
	}

	public void plusDiabetes() {
		diabetes += 1;
	}

	public void plusHypertension() {
		hypertension += 1;
	}

	/*
	 * public void plusHyperthyroidismO() {
	 * hyperthyroidismO += 1;
	 * }
	 * 
	 * public void plusHyperthyroidismUT() {
	 * hyperthyroidismUT += 1;
	 * }
	 * 
	 * public void plusMigraine() {
	 * migraine += 1;
	 * }
	 * 
	 * public void plusPneumonia() {
	 * pneumonia += 1;
	 * }
	 * 
	 * public void plusUTI() {
	 * uti += 1;
	 * }
	 */

	public String getWinner() {

		if (flu > commonCold && flu > asthma && flu > diabetes && flu > hypertension && flu > hyperthyroidismO
				&& flu > hyperthyroidismUT && flu > migraine && flu > pneumonia && flu > uti) {
			String winner = "Flu";
			return winner;
		} else if (commonCold > flu && commonCold > asthma && commonCold > diabetes && commonCold > hypertension
				&& commonCold > hyperthyroidismO && commonCold > hyperthyroidismUT && commonCold > migraine
				&& commonCold > pneumonia && commonCold > uti) {
			String winner = "Common Cold";
			return winner;
		} else if (asthma > commonCold && asthma > flu && asthma > diabetes && asthma > hypertension
				&& asthma > hyperthyroidismO && asthma > hyperthyroidismUT && asthma > migraine && asthma > pneumonia
				&& asthma > uti) {
			String winner = "Asthma";
			return winner;
		} else if (diabetes > commonCold && diabetes > asthma && diabetes > flu && diabetes > hypertension
				&& diabetes > hyperthyroidismO && diabetes > hyperthyroidismUT && diabetes > migraine
				&& diabetes > pneumonia && diabetes > uti) {
			String winner = "Diabetes";
			return winner;
		} else if (hypertension > commonCold && hypertension > asthma && hypertension > diabetes && hypertension > flu
				&& hypertension > hyperthyroidismO && hypertension > hyperthyroidismUT && hypertension > migraine
				&& hypertension > pneumonia && hypertension > uti) {
			String winner = "Hypertension";
			return winner;
		} else {

			// int tmp = 0;
			// for (int i = 0; i < arr.length; i++) {
			// for (int j = 1; j < arr.length - i; j++) {
			// if(arr[j-1] > arr[j]) {
			// tmp = arr[j-1];
			// arr[j-1] = arr[j];
			// arr[j] = tmp;
			// }
			// }
			// }

			return "Tie";
		}
	}

	/*
	 * else if (hyperthyroidismO > commonCold && hyperthyroidismO > asthma &&
	 * hyperthyroidismO > diabetes && hyperthyroidismO > hypertension &&
	 * hyperthyroidismO > flu && hyperthyroidismO > hyperthyroidismUT &&
	 * hyperthyroidismO > migraine && hyperthyroidismO > pneumonia &&
	 * hyperthyroidismO > uti) {
	 * String winner = "Hyperthyroidism (Overactive)";
	 * return winner;
	 * } else if (hyperthyroidismUT > commonCold && hyperthyroidismUT > asthma &&
	 * hyperthyroidismUT > diabetes && hyperthyroidismUT > hypertension &&
	 * hyperthyroidismUT > hyperthyroidismO && hyperthyroidismUT > flu &&
	 * hyperthyroidismUT > migraine && hyperthyroidismUT > pneumonia &&
	 * hyperthyroidismUT > uti) {
	 * String winner = "Hyperthyroidism (Underactive)";
	 * return winner;
	 * } else if (migraine > commonCold && migraine > asthma && migraine > diabetes
	 * && migraine > hypertension && migraine > hyperthyroidismO && migraine > flu
	 * && migraine > hyperthyroidismUT && migraine > pneumonia && migraine > uti) {
	 * String winner = "Migraine";
	 * return winner;
	 * } else if (pneumonia > commonCold && pneumonia > asthma && pneumonia >
	 * diabetes && pneumonia > hypertension && pneumonia > hyperthyroidismO &&
	 * pneumonia > hyperthyroidismUT && pneumonia > migraine && pneumonia > flu &&
	 * pneumonia > uti) {
	 * String winner = "Pneumonia";
	 * return winner;
	 * } else if (uti > commonCold && uti > asthma && uti > diabetes && uti >
	 * hypertension && uti > hyperthyroidismO && uti > hyperthyroidismUT && uti >
	 * migraine && uti > pneumonia && uti > flu) {
	 * String winner = "Urinary Tract Infection";
	 * return winner;
	 * }
	 */

}
